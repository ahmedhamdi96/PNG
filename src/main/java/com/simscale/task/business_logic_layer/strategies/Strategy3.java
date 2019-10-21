package com.simscale.task.business_logic_layer.strategies;


public class Strategy3 extends PrimeStrategy {

    @Override
    boolean isPrime(Integer n) {
        if (n == 1){
            return false;
        }

        if (n == 2){
            return true;
        }

        if (n > 2 && n%2 == 0){
            return false;
        }

        Integer maxDivisor = (int) Math.floor(Math.sqrt(n));

        for(Integer i=3; i<=maxDivisor; i+=2){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
