# PNG
*Prime Number Generator*

## Project Overview

A JavaEE web application to a prime number generator with 4 different prime number generation strategies with different performance optimizations.

## Libraries
* Maven: project build
* thorntail: packaging war into jar
* JAX-RS: web app and RESTful services
* EJB: web container
* JPA: relational data management
* MySQL: database
* Log4j: logging

## How To Run

> mvn clean install

> java -jar target/PrimeNumberGenerator-thorntail.jar

> GET http://localhost:8080/app/prime

*build and run the application, then make a GET request*

## References
* [Prime Number Generation Analysis](https://www.geeksforgeeks.org/analysis-different-methods-find-prime-number-python/)
* [Thorntail Project Generator](https://thorntail.io/generator/)
