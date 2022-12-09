create function add_customer()
    returns trigger as
$$
BEGIN
    execute format('create user %I with password ''%I''', new.username, new.pass);
    execute format('alter group customers add user %I', new.username);
    return new;
END;
$$
LANGUAGE 'plpgsql';

create function add_account()
    returns trigger as
$$
BEGIN
    insert into Owners values (new.acct_num, CURRENT_USER);
    return new;
END;
$$
LANGUAGE 'plpgsql';

create function add_employee()
    returns trigger as
$$
BEGIN
    execute format('create user %I with password ''%I''', new.username, new.pass);
    if new.occupation = 'teller' then 
        execute format('alter group tellers add user %I', new.username);
    elsif new.occupation = 'manager' then 
        execute format('alter group managers add user %I', new.username);
    elsif new.occupation = 'loan specialist' then 
        execute format('alter group loan_specialists add user %I', new.username);
    end if;
    return new;
END;
$$
LANGUAGE 'plpgsql';

create function insert_transaction()
    returns trigger as
$$
BEGIN
    if new.acct_num in (select acct_num from Account) then
        update Account set balance = CASE
                                        when new.type = 'deposit' then (balance + new.amount)
                                        when new.type = 'withdrawal' then (balance - new.amount)
                                        when new.type = 'external transfer' then (balance - new.amount)
                                     END
            where acct_num = new.acct_num;
        update Transactions set balance_after = (select balance from Account where acct_num = new.acct_num) 
            where id = new.id;
    end if;
    return new;
END;
$$
LANGUAGE 'plpgsql';