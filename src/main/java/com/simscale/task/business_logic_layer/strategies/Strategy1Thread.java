package com.simscale.task.business_logic_layer.strategies;


public class Strategy1Thread extends PrimeStrategyThread {

    public Strategy1Thread(String name, Integer from, Integer to) {
        super(name, from, to);
    }

    /**
     * Strategy1Thread determines that a number "n" is prime by
     * making sure that n does not have any factors from
     * [2, n-1] inclusive
     */

    @Override
    Boolean isPrime(Integer n) {
        if (n == 1){
           return false;
        }

        for(int i=2; i<n; i++){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
