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

### Web Application

> mvn clean install

> java -jar target/PrimeNumberGenerator-thorntail.jar

> GET http://localhost:8080/app/prime?from=X&to=Y&strategy=Z

*build and run the application, then make a GET request having the required parameters*

* Strategies : strategy_1, strategy_2, strategy_3, sieve_strategy

### Command-line 

> mvn compile

> mvn exec:java -Dexec.mainClass="com.simscale.task.main.Main" -Dexec.args="1 100 sieve_strategy"

*"1 100 sieve_strategy" is an example showing how to pass arguments*

* Strategies : strategy_1, strategy_2, strategy_3, sieve_strategy

## References
* [Prime Number Generation Analysis](https://www.geeksforgeeks.org/analysis-different-methods-find-prime-number-python/)
* [Thorntail Project Generator](https://thorntail.io/generator/)
