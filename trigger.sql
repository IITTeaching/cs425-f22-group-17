create trigger add_customer_trigger
    after INSERT
    on Customer
    for each row
    execute procedure add_customer();

create trigger add_employee_trigger
    after INSERT
    on Employee
    for each row
    execute procedure add_employee();

create trigger add_account_trigger
    after Insert
    on Account
    for each row
    execute procedure add_account();

create trigger insert_transaction_trigger
    after INSERT
    on Transactions
    for each row
    execute procedure insert_transaction();
