# Air France test application

## For cloning the project to your machine:

```
$ git clone https://github.com/aabbadi9797/airfrance.git
```

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [MongoDB](https://www.mongodb.com/try/download/community)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.airfrance.test.TestApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## API

Method | Path           | Description                    |
-------|----------------|--------------------------------|
POST    | /users/create      | create a new user      |
GET    | /users/{id} | retrieve a user by its ID |

## Postman
In [POSTMAN](https://www.postman.com/downloads) you click on <b>Import</b> button in the top left :


![alt text](https://github.com/aabbadi9797/airfrance/blob/main/postman1.bmp)



Click on <b>Upload Files</b> button, then select the <b>airfrance.postman_collection.json</b> file :


![alt text](https://github.com/aabbadi9797/airfrance/blob/main/postman2.bmp)



Now <b>airfrance</b> collection is added in the left pannel with the API :


![alt text](https://github.com/aabbadi9797/airfrance/blob/main/postman3.bmp)



## Swagger Documentation

After running the project you can see the API in the Swagger documentation , accessible in : http://localhost:8080/swgger-ui.html


![alt text](https://github.com/aabbadi9797/airfrance/blob/main/SWAGGER.bmp)
