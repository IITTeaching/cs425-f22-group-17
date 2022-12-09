-- Active: 1670181037590@@group17database.net@5432@postgres
create table Branch
(
    addr_num int,
    street varchar,
    city varchar,
    state varchar,
    zip char(5),
    primary key (addr_num, street, city, state, zip)
);

create table Customer
(
    username varchar(20),
    pass varchar,
    first_name varchar,
    last_name varchar,
    addr_num int,
    street varchar,
    city varchar,
    state varchar,
    zip char(5),
    b_addr_num int,
    b_street varchar,
    b_city varchar,
    b_state varchar,
    b_zip char(5),
    primary key(username),
    foreign key(b_addr_num, b_street, b_city, b_state, b_zip) references Branch on delete cascade
);

create table Employee
(
    username varchar(20),
    pass varchar,
    first_name varchar,
    last_name varchar,
    ssn NUMERIC(9),
    salary DECIMAL(8,2),
    occupation VARCHAR,
    addr_num int,
    street varchar,
    city varchar,
    state varchar,
    zip char(5),
    primary key (ssn),
    foreign key (addr_num, street, city, state, zip) references Branch on delete cascade,
    check (occupation='teller' or occupation='loan specialist' or occupation='manager')
);

create table Account
(
    acct_num numeric(12),
    balance numeric(10,2) DEFAULT 0,
    type varchar,
    interest int DEFAULT 0,
    primary key (acct_num),
    check ((type = 'checking') or (type = 'savings' and balance >= 0)),
    check ((interest = 0 and type = 'checking') or (interest >= 0 and type = 'savings'))
);

create sequence account_num_seq;
alter table Account alter column acct_num type numeric(12);
alter table Account alter column acct_num set DEFAULT nextval('account_num_seq');
alter SEQUENCE account_num_seq owned by Account.acct_num;
create table Owners
(
    acct_num numeric(12),
    username varchar(20),
    foreign key (username) references Customer on delete cascade,
    foreign key (acct_num) references Account on delete cascade
);

create table Transactions
(
    id serial,
    acct_num numeric(12),
    type VARCHAR,
    amount NUMERIC(10,2),
    description text,
    date date DEFAULT CURRENT_DATE,
    balance_after numeric(10,2) default 0,
    primary key (id),
    foreign key (acct_num) references Account on delete cascade,
    check ((type='withdrawal' or type='deposit' or type='transfer' or type='external transfer'))
);
