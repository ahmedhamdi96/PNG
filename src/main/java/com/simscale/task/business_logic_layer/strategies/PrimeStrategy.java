package com.simscale.task.business_logic_layer.strategies;

import java.util.ArrayList;

public abstract class PrimeStrategy {

    abstract boolean isPrime(Integer n);

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
