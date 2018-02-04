This note guides you how to create a MySQL database to run the application.

- First, execute SQL queries in STEP 1 as specified in the DatabaseDefinition.sql file.
  This will create a local MySQL database in which our application is going to
  select, insert, update and delete data.

- When your application is ready for deploy as a production, do STEP 2 in the
  DatabaseDefinition.sql file. Then change the
  
    spring.jpa.hibernate.ddl-auto=create
  
  to
  
    spring.jpa.hibernate.ddl-auto=none
  
  This change is to avoid SQL injection attacks that may lead to the database and its
  data is corrupted by attackers.
  
  When you want to make changes on the database:
    + Re-grant the permission
    + Change the 'spring.jpa.hibernate.ddl-auto' to 'update'
    + Re-run the application