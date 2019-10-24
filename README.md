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

## Strategies

### Strategy1
Strategy1 determines that a number "n" is prime by making sure that n does not have any factors from [2, n-1] inclusive.

### Strategy2
Strategy2 determines that a number "n" is prime by making sure that n does not have any factors from [2, floor(sqrt(n))] inclusive. This is valid due to the fact that a natural number's factors tend to be mirrored after reaching floor(sqrt(n)).

### Strategy3
Strategy3 builds on Strategy2 and applies the following optimizations: 
1) an even number other than 2 can never be prime, ignore even numbers
2) check for factors between [3, floor(sqrt(n))] inclusive with double increments instead of single increments, because and odd number can have odd factors only
     
### SieveStrategy
SieveStrategy is an implementation of the of the Sieve of Eratosthenes. SieveStrategy uses a an array of flags of size equal to param "to" the flags array identifies whether the number at the corresponding index is prime or not. When traversing the flags array to return a list of primes from param "to" to param "from", indices < param "from" are ignored. 
 
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

### Testing

> mvn test

## Threads

The application runs multiple threads based on the number of cores of the runtime environment. The payload which is the list of numbers from the given starting integer to the final integer is split into equal payloads and passed to the threads. The results from the threads are merged together to return the final list of prime numbers.

| Strategy      | W/O Threading | W/ Threading  | Improvement |
| :------------ | :------------ | :------------ | :---------- |
| Strategy1     | 122.037s      | 39.645s       | 68%         |
| Strategy2     | 0.279s        | 0.126s        | 55%         |
| Strategy3     | 0.175s        | 0.087s        | 50%         |

*test was applied on the range [1, 1000000]*

*no threading was applied on the SieveStrategy (Sieve of Eratosthenes)*

*to activate threading set the flag (runSingleThread) on com.simscale.task.business_logic_layer.thread_management.ThreadManagement:15 to false*

## References
* [Prime Number Generation Analysis](https://www.geeksforgeeks.org/analysis-different-methods-find-prime-number-python/)
* [Thorntail Project Generator](https://thorntail.io/generator/)
s