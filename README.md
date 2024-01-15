# springboot-sample-app

![Forks](https://img.shields.io/github/forks/Dornelas-Study/microservice)
![Stars](https://img.shields.io/github/stars/Dornelas-Study/microservice)
![Last Commit](https://img.shields.io/github/last-commit/Dornelas-Study/microservice)
[![Continuos Integration with GitHub](https://github.com/Dornelas-Study/microservice/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/Dornelas-Study/microservice/actions/workflows/docker-publish.yml)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0.html) file.