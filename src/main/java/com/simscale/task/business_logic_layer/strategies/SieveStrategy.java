package com.simscale.task.business_logic_layer.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SieveStrategy {

    public ArrayList<Integer> generatePrimes(Integer from, Integer to) {

        ArrayList<Integer> primes = new ArrayList<Integer>();

        int primeFlagsListSize = to + 1;
        ArrayList<Boolean> primeFlagsList = new ArrayList<Boolean>(Arrays.asList(new Boolean[primeFlagsListSize]));
        Collections.fill(primeFlagsList, Boolean.TRUE);

        Integer maxDivisor = (int) Math.floor(Math.sqrt(primeFlagsListSize));
        for (int i = 2; i<=maxDivisor; i++) {
            if(primeFlagsList.get(i)){
                for (int j = i*i; j<primeFlagsListSize; j+=i){
                    primeFlagsList.set(j, Boolean.FALSE);
                }
            }

        }

        for (int i = 2; i<primeFlagsListSize; i++) {
            if(i>=from && primeFlagsList.get(i)){
                primes.add(i);
            }
        }
        return primes;
    }

}
