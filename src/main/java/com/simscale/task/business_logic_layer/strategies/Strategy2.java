package com.simscale.task.business_logic_layer.strategies;


public class Strategy2 extends PrimeStrategy {

    /**
     * Strategy2 determines that a number "n" is prime by
     * making sure that n does not have any factors from
     * [2, floor(sqrt(n))] inclusive. This is valid due
     * to the fact that a natural number's factors tend
     * to be mirrored after reaching floor(sqrt(n)).
     */

    @Override
    Boolean isPrime(Integer n) {
        if (n == 1){
            return false;
        }

        int maxFactor = (int) Math.floor(Math.sqrt(n));

        for(int i=2; i<=maxFactor; i++){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
