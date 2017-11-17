# Checkout component 3.0

## Project structure

* Java 8
* Spring Boot
* Hibernate
* PostgreSQL
* Gradle
* Docker
* Swagger Docs

## How to build/deploy

### Locally (requires PostgreSQL)
```
<project-root>$ ./gradlew build
<project-root>$ java -jar build/libs/checkout-component-0.1.0.jar
```

### Docker
```
<project-root>$ ./gradlew build buildImage
<project-root>$ docker-compose up
```

## Swagger Docs
Swagger documentation is available at: http://localhost:8080/

