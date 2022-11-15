drop table if exists Branch cascade;
drop table if exists Customer cascade;
drop table if exists Employee cascade;
drop table if exists Account cascade;
drop table if exists Owners cascade;
drop table if exists transaction cascade;

drop role if exists customer;

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
    primary key(first_name, last_name),
    foreign key(b_addr_num, b_street, b_city, b_state, b_zip) references Branch on delete cascade
);

create table Employee
(
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
    primary key (acct_num)
);

create table Owners
(
    acct_num numeric(12),
    first_name varchar,
    last_name varchar,
    foreign key (first_name, last_name) references Customer on delete cascade,
    foreign key (acct_num) references Account on delete cascade
);

create table Transaction
(
    id int not null,
    acct_num numeric(12),
    type VARCHAR,
    amount NUMERIC(10,2),
    description text,
    primary key (id),
    foreign key (acct_num) references Account on delete cascade,
    check (type='withdrawal' or type='deposit' or type='transfer' or type='external transfer')
);