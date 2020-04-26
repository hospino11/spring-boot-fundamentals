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

## Spring Boot Maven Plugin
It repackages your .jar and .war files to be executable. For jar files It collects all the jars on the classpath 
and builds a single runnable Uber jar. It also runs your Spring Boot application and searches for the public static void
main method to flag as a runnable class. It provides a built-in dependency resolver that says the version number 
to match the Spring Boot dependencies. It also manages the lifecycle of Spring Boot application and generates build 
information that can be used by who call the actuator, that provides at monitoring and metrics.

## REST Architecture Style
### Representational State Transfer (REST)
It's a set of guidelines application developers use to design APIs. There are four principles that APIs follow:
- Data and functionality are considered resources and identified by something called URI (Uniform Resource Identifier).
- Resources are manipulated using a fixed set of operations.
    - GET retrieves resources
    - POST creates resource
    - PUT updates resources
    - DELETE removes resources
    - PATCH updates resources partially by the given information
- Resouces can be represented in multiple formats.
- Communication between the client and endpoint is stateless.

ResponseEntity tells to Spring that the returned value of the method is serialized directly to the body of the http 
response. It represents the entire Http Response which has http status, headers and the response body.

ResponseStatusException is a programmatic alternative to @ResponseStatus. It provides HttpStatus and a reason and a 
cause. It provides more control over exception handling, so the exceptions can be created programmatically. 
Spring Boot provides a default error mapping. 

@RestController is a shortcut of the @Controller and @ResponseBody annotations. Using this annotation, we cannot access 
to the model.

## GraphQL
GraphQL is a query language for APIs or a syntax that describes ow to ask for data. Each query will have a specific 
object that it returns and based on the object returned you can add or remove fields which match the exact data you 
need to fit your specific case. 

### Features
- Allows client to specify the exact data needed.
- Aggregation of data from multiple sources, allowing the client to get the needed information with one call.
- No longer required to call multiple APIs for needed data.
- GraphQL offers maximum efficiency and flexibility.

### Schemas
The schema defines data points offered via an API. The schema contains the datatypes and relationships between them and 
the operations available such as queries for retrieving data and mutations for creating, updating and deleting data.
The graphql-jav-tools dependency parses schemas ending in ".graphqls" which are found behind the scenes in the 
classpath, processed and the necessary beans are autowired.  

## Actuator
Actuator provides health checks, auditing, metrics gathering and http tracing by exposing HTTP or JMX endpoints.

See application.properties for more information of actuator configuration.

## Testing
JUnit, Mockito and Spring Test (also known as MockMvc) for testing Rest APIs.
### @WebMvcTest
An annotation used for controller layer unit testing. It's often used to test one controller at a time. Scans only 
controllers including @Controller and @RestController and will not load full application context. It the controller has 
dependencies of other beans the test will not run until you provide the instance yourself or a mocked instance.
@WebMvcTest speeds up testing by loading small portion of your application.
### Integration Testing
Allows testing the entire application in every layer as not such as individual units. It can be performed without 
deployment of an application. @SpringBootTest annotation is used for integration testing. It's chosen over @WebMvcTest 
because @SpringBootTest starts full application context including the server and does not customize component scanning 
at all. @SpringBootTest locates the main configuration class annotated with the @SpringBootApplication annotation.