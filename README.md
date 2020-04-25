# spring-boot-fundamentals
Spring Boot Fundamentals

## Overview
Spring Boot is just an extension of Spring Framework. It provides as much simpler and faster way to setup and configure 
your application. Automatic configuration based on libraries added to classpath.
Starter dependencies: starter packs that include all of the dependent libraries that you need. 
Actuator allows you to manage and monitor your applications.

## Auto-configuration
It's a very useful and powerful feature of Spring Boot, which takes a "convention-over-configuration" approach.
Auto configuration looks at the classpath for JARs and auto-configures beans. For example, It'll configure a data source
if Hibernate jar is present in the classpath or a DispatcherServlet if Spring MVC jar is found in the classpath.
Auto configuration is designed as non-invasive this means that the default configuration will back away if you set up 
your own configuration. Auto configuration is always applied after beans configuration defined by the user.
If you need to checkout the configurations applied you can use the flag --debug when you start your application or simply 
adding a property to application.properties file. Also, you can use the Spring Boot Actuator.

## @SpringBootApplication
It had to be added in the main application class to indicate that the application should utilize Spring Boot.
It's a shortcut annotation that applies three annotations in one statement:
- @SpringBootConfiguration: replaces @Configuration and annotates a class as a configuration.
- @EnableAutoConfiguration: tells Spring Boot to configure beans.
- @ComponentScan: tells Spring Boot to scan current package and subpackages.

## H2 Database
It's an open source database written in Java. It's an in-memory database. It's good for POCs, dev environments ans 
simple database. H2 database is not recommended for production environment. H2 provides an administrator tool that can 
be accessed by the web browser.

## ORM (Object Relational Mapping) with JPA
There are several layers of abstraction. At the lowest level there is the persistence data store. Above that is JDBC 
(Java) database connectivity. It's a Java API to connect and executes queries against the database. 
JPA (Java Persistence API) It's an abstraction on top of JDBC that makes it easy to map Java objects to relational 
databases and vice-versa. JPA is just a specification or a set of guidelines and It cannot do anything on its own. 
And It is only a set of empty methods and collection of interfaces that only describes Java persistence methodology.
In order to be fully functional, JPA needs an implementation also known as **instance provider**. Spring with JPA uses 
Hibernate as instance provider. **Spring Data JPA** provides repository support por the Java persistence API. It eases 
development of applications that need to access JPA data sources. 

### Spring Data JPA
Spring Data JPA provides the following key 
dependencies:
- Hibernate: which is known as the most popular JPA implementation.
- Spring Data JPA: which makes it easy to implement JPA based repository.
- Spring ORM: is the core ORM Spring Framework support.  

Spring Data repositories reduces boilerplate code to implement data access for any database. It allows to access data 
by creating JPA queries automatically from a method name.

## Entities
Entities are objects that live in the database, and they have the ability to be mapped to a database.
Entities are defined by the @Entity annotation. If the @Table annotation is missing, the entity will be mapped to 
a table which has the same name as the entity class name. 

## MVC
- Model: representation of data in a system.
- View: responsible for displaying data.
- Controller: responsible for directing incoming user requests to the correct resources and send the responses from 
those resources back to the user.

Controller layer uses the @Controller annotation.
Service layer contains the business logic to retrieve the data using the repository layer.  
