create role guest;
create role customers;
create role managers;
create role tellers;
create role loan_specialists;

grant insert on Customer to guest;
grant select, insert, update, delete on Account to customers;
grant select, insert, update on Transcations to customers;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO managers;
grant select, insert, update, delete on Transactions to tellers;
grant select, insert, update on Owners to customers;

GRANT ALL PRIVILEGES ON schema public TO customers;
GRANT ALL PRIVILEGES ON schema public TO managers;

alter table Customer enable row level security;
create policy themselves on Customer to customers
    using (username = CURRENT_USER);

alter table Account enable row level security;
create policy account_select_policy on Account for SELECT to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));

alter table Account enable row level security;
create policy account_update_policy on Account for UPDATE to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));

alter table Account enable row level security;
create policy account_delete_policy on Account for DELETE to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));

alter table Transactions enable row level security;
create policy transactions_policy on Transactions to customers
    using (acct_num in (select acct_num from Owners where username = CURRENT_USER));

create policy account_insert_policy on Account for INSERT to customers with check(true);