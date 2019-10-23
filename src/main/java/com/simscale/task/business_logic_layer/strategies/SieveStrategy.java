package com.simscale.task.business_logic_layer.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SieveStrategy {

    /**
     * SieveStrategy is an implementation of the of the Sieve of Eratosthenes.
     * SieveStrategy uses a an array of flags of size equal to param "to"
     * the flags array identifies whether the number at the corresponding
     * index is prime or not. When traversing the flags array to return
     * a list of primes from param "to" to param "from", indices < param "from"
     * are ignored.
     */

    public ArrayList<Integer> generatePrimes(Integer from, Integer to) {

        //list of primes to be returned
        ArrayList<Integer> primes = new ArrayList<Integer>();

        //boolean array initialized with true to identify whether a number is prime or not
        int primeFlagsListSize = to + 1;
        ArrayList<Boolean> primeFlagsList = new ArrayList<Boolean>(Arrays.asList(new Boolean[primeFlagsListSize]));
        Collections.fill(primeFlagsList, Boolean.TRUE);

        //0 and 1 are not prime
        primeFlagsList.set(0, false);
        primeFlagsList.set(1, false);

        //Sieve of Eratosthenes algorithm
        int maxFactor = (int) Math.floor(Math.sqrt(primeFlagsListSize));
        for (int i = 2; i<=maxFactor; i++) {
            if(primeFlagsList.get(i)){
                for (int j = i*i; j<primeFlagsListSize; j+=i){
                    primeFlagsList.set(j, Boolean.FALSE);
                }
            }

        }

        //traversing the flags array starting from index param "from" to construct the primes array
        for (int i = from; i<primeFlagsListSize; i++) {
            if(primeFlagsList.get(i)){
                primes.add(i);
            }
        }

        return primes;
    }

}
