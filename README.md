# book-store-application-backend
Instructions:
A)Application uses h2 database and creates two users with role User,Admin. When application starts it creates users as following
1) username: user, password: user role User
2) username: admin, password: admin 
All data is lost as soon you restart the server
B) if you want use MySql or Postgress then add their dependencies and create a database schema `book` and update application.properties file.
#mysql configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/fyp-book?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=aman
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.initialization-mode=always
spring.jpa.show-sql=true
server.port=8080
1) Open project in any IDE and run it or if you use mvn then go to src folder. mvn spring-boot:run
2) Make sure to run application  on default 8080 port.
