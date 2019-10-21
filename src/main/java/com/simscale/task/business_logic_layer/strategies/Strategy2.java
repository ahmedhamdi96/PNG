package com.simscale.task.business_logic_layer.strategies;


public class Strategy2 extends PrimeStrategy {

    @Override
    boolean isPrime(Integer n) {
        if (n == 1){
            return false;
        }

        Integer maxDivisor = (int) Math.floor(Math.sqrt(n));

        for(Integer i=2; i<=maxDivisor; i++){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
