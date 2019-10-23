package com.simscale.task.business_logic_layer.strategies;

import java.util.ArrayList;

public abstract class PrimeStrategy {

    /**
     * checks whether the given number is a prime or not
     * @param n input integer
     * @return flag
     */
    abstract Boolean isPrime(Integer n);

    /**
     * generates a list of primes from "from" to "to" inclusive
     * @param from natural number to start with
     * @param to natural number to end with
     * @return list of primes
     */
    public ArrayList<Integer> generatePrimes(Integer from, Integer to) {

        ArrayList<Integer> primes = new ArrayList<Integer>();

        for (int i=from; i<=to; i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }
}
