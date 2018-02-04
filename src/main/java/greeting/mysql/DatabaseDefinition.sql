-- STEP 1: Create the database, the user through which our Spring app
-- is going to access the database.
show databases;

-- Create the new database
create database db_example;

-- Create the user
create user 'springuser'@'localhost'
	identified by 'ThePassword';

-- Give all the privileges to the new user on the newly created database
grant all on db_example.* to 'springuser'@'localhost';

use db_example;
show tables;


-- STEP 2: Change security priviliges from the 'springuser'@'localhost'
-- before expose the app to user (when the app is in production)

-- Revoke all the priviliges from the user associated with our Spring app.
revoke all on db_example.* from 'springuser'@'localhost';

-- Now the Spring app cannot do any thing in the database.
-- We don't want that, so we allow the Spring app to do CRUD operations.
grant select, insert, delete, update on db_example.* to 'springuser'@'localhost';