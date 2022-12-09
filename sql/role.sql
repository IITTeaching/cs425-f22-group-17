-- Active: 1670181037590@@group17database.net@5432@postgres
create role customers;
create role managers;
create role tellers;
grant select on Branch to customers;
grant select on Branch to managers;
grant select on Branch to tellers;
grant insert on Branch to managers;
grant update on Branch to managers;
grant delete on Branch to managers;
alter table Account enable row level security;
grant select on Account to customers;
create policy customer_account_select_policy on Account for select to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));
grant select on Account to managers;
create policy manager_account_select_policy on Account for select to managers
    using (true);
grant select on Account to tellers;
create policy teller_account_select_policy on Account for select to tellers
    using (true);
grant insert on Account to customers;
create policy customer_account_insert_policy on Account for insert to customers
    with check(true);
grant insert on Account to managers;
create policy manager_account_insert_policy on Account for insert to managers
    with check(true);
grant update on Account to customers;
create policy customer_account_update_policy on Account for update to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));
grant update on Account to managers;
create policy manager_account_update_policy on Account for update to managers
    using (true);
grant update on Account to tellers;
create policy teller_account_update_policy on Account for update to tellers
    using (true);
grant delete on Account to managers;
create policy manager_account_delete_policy on Account for delete to managers
    using (true);
grant delete on Account to customers;
create policy customer_account_delete_policy on Account for delete to customers
    using(acct_num in (select acct_num from Owners where username = CURRENT_USER));
alter table Customer enable row level security;
grant select on Customer to managers;
create policy manager_customer_select_policy on Customer for select to managers
    using (true);
grant select on Customer to customers;
create policy customer_customer_select_policy on Customer for select to customers
    using(username = CURRENT_USER);
grant insert on Customer to managers;
create policy manager_customer_insert_policy on Customer for insert to managers
    with check(true);
grant update on Customer to managers;
create policy manager_customer_update_policy on Customer for update to managers
    using (true);
grant update on Customer to customers;
create policy customer_customer_update_policy on Customer for update to customers
    using (username = CURRENT_USER);
grant delete on Customer to managers;
create policy manager_customer_delete_policy on Customer for delete to managers
    using (true);
alter table Employee enable row level security;
grant select on Employee to managers;
create policy manager_employee_select_policy on Employee for select to managers
    using (true);
grant select on Employee to tellers;
create policy teller_employee_select_policy on Employee for select to tellers
    using(username = CURRENT_USER);
grant insert on Employee to managers;
create policy manager_employee_insert_policy on Employee for insert to managers
    with check(true);
grant update on Employee to managers;
create policy manager_employee_update_policy on Employee for update to managers
    using (true);
grant delete on Employee to managers;
create policy mangager_employee_delete_policy on Employee for delete to managers
    using (true);
alter table Owners enable row level security;
grant select on Owners to customers;
create policy customer_owners_select_policy on Owners for select to customers
    using(username = CURRENT_USER);
grant select on Owners to managers;
create policy manager_owners_select_policy on Owners for select to managers
    using (true);
grant select on Owners to tellers;
create policy teller_owners_select_policy on Owners for select to tellers
    using (true);
grant insert on Owners to customers;
create policy customer_owners_insert_policy on Owners for insert to customers
    with check(username = CURRENT_USER);
grant insert on Owners to managers;
create policy manager_owners_insert_policy on Owners for insert to managers
    with checK(true);
grant update on Owners to managers;
create policy manager_owners_update_policy on Owners for update to managers
    using (true);
grant delete on Owners to managers;
create policy manager_owners_delete_policy on Owners for delete to managers
    using (true);
alter table Transactions enable row level security;
grant select on Transactions to customers;
create policy customer_transactions_select_policy on Transactions for select to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));
grant select on Transactions to managers;
create policy manager_transactions_select_policy on Transactions for select to managers
    using (true);
grant select on Transactions to tellers;
create policy teller_transactions_select_policy on Transactions for select to tellers
    using (true);
grant insert on Transactions to customers;
create policy customer_transactions_insert_policy on Transactions for insert to customers
    with check(acct_num in (select acct_num from Owners where username = CURRENT_USER));
grant insert on Transactions to managers;
create policy manager_transactions_insert_policy on Transactions for insert to managers
    with check(true);
grant insert on Transactions to tellers;
create policy teller_transactions_insert_policy on Transactions for insert to tellers
    with check(true);
grant update on Transactions to managers;
create policy manager_transactions_update_policy on Transactions for update to managers
    using (true);
grant update on Transactions to customers;
create policy customer_transations_update_policy on Transactions for update to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));
grant update on Transactions to tellers;
create policy teller_transactions_update_policy on Transactions for update to tellers
    using (true);
grant all privileges on sequence transactions_id_seq to customers;
grant all privileges on sequence transactions_id_seq to managers;
grant all privileges on sequence transactions_id_seq to tellers;
grant all privileges on sequence account_num_seq to customers;
grant all privileges on sequence account_num_seq to managers;
grant all privileges on sequence account_num_seq to tellers;