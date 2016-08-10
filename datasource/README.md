# Overview
This example demonstrate how to use a datasource in Camel.
We'll be using both Camel-jdbc and Camel-sql to show the difference in between those 2 features.

# Compatibility
The example is developped for Fuse v6.2 on Karaf in Fabric mode.


# Database
We use MySQl v5.6.31.
The driver is installed along with the application thanks to the <fabric8:bundles> definition from the top of the pom.xml

## Table
A mysql_table.txt text file is present in src/main/resource and contains the command to create an appropriate table.
The table is to be created in the default "test" database.


# Application
This is a simple application that exposes an HTTP interface and write some information in a MySQL database.
The application listens to localhost:9082/ds and expect an "amount" parameter --> http://localhost:9082/ds?amount=100
The application will simply return 'request processed!' at the end of the flow in a custom HTML body.

## Queries
There are 3 queries within the application:
- one statement gets the next value of the primary key.
  this is to demonstrate a simple way of using sequence in mysql via the "auto_increment" feature.
  the result is processed in a custom bean processor in order to demonstrate how to use the result (returned as a Map<String,Object>, where the key is the Mysql column name and the value the Mysql column data).
- one statement does an "insert" in the database
  this is done using camel-jdbc with the query in the Message body
- one statement performs an "update" in the database
  this is done using camel-sql, to show how to use paramerized values with this feature


## Remark
The datasource configuration in blueprint doesn't resolve the properties from the placeholder.



# Links
* [Fabric8 maven plugin](http://fabric8.io/gitbook/mavenPlugin.html)

