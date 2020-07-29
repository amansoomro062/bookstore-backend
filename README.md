# book-store-application-backend
Instructions:
A)Application uses h2 database and creates two users with role User,Admin. When application starts it creates users as following
1) username: user, password: user role User
2) username: admin, password: admin 
All data is lost as soon you restart the server
B) if you want use MySql or Postgress then add their dependencies and create a database schema `book` and update application.properties file.
#postgress configuration
#spring.datasource.url=jdbc:postgresql://localhost:5432/book
#spring.datasource.username=mydbusername
#spring.datasource.password=mydbpassword
C) if you are using Mysql or Postgress go to main class which is BookStoreApplication and make sure you don't create default users. Users are created in
  `run()` method inside BookStoreApplication.class
Development server: How to run it
1) Open project in any IDE and run it or if you use mvn then go to src folder. mvn spring-boot:run
2) Make sure to run application  on default 8080 port.
