package com.simscale.task.business_logic_layer.strategies;


public class Strategy1 extends PrimeStrategy {

    @Override
    boolean isPrime(Integer n) {
        if (n == 1){
           return false;
        }

        for(Integer i=2; i<n; i++){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
