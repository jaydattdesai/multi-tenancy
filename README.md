# multi-tenancy

* The purpose of this PoC is to provide dynamic database routing based on the tenant id passed in request header as 'X-TenantID'
* There are 2 sql scripts testdb1_sample_entity.sql and testdb2_sample_entity.sql. Copy the contents from this file and paste it on my sql command line and it will create schema and table for you
* Thesse files will create 2 schema's testdb1 and testdb2 with the same table name called **sample_entity** with same properties 
* Change the spring.datasource.* properties according to your database connection properties in application.properties file
* Execute mvn command called **./gradlew clean build**  in multi-tenancy directory
* It will create a jar file in build/libs directry : build/libs/multi-tenancy-0.0.1-SNAPSHOT.jar
* Now, execute a command called **java -jar build/libs/multi-tenancy-0.0.1-SNAPSHOT.jar** from multi-tenancy directory and it will start your application
* Use rest endpoint as below for creating records in sample_entity table
* The URL will be as below

URL: http://localhost:8080/samples

HTTP method: POST

Payload: {
	"name":"db2"
}

Header: User X-TenantID - datasource1 for inserting this record in testdb1 schema and user datasoruce 2 for inserting this record in testdb2 schema.

* For getting all the records use below:

HTTP method : GET

Header: User X-TenantID - datasource1 for inserting this record in testdb1 schema and user datasoruce 2 for inserting this record in testdb2 schema.
