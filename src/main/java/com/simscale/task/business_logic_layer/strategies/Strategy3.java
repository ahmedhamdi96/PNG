package com.simscale.task.business_logic_layer.strategies;


public class Strategy3 extends PrimeStrategy {

    /**
     * Strategy3 builds on Strategy2 and applies the
     * following optimizations:
     * 1) an even number other than 2 can never be prime, ignore even numbers
     * 2) check for factors between [3, floor(sqrt(n))] inclusive with double
     * increments instead of single increments, because and odd number can have
     * odd factors only
     */

    @Override
    Boolean isPrime(Integer n) {
        if (n == 1){
            return false;
        }

        if (n == 2){
            return true;
        }

        if (n > 2 && n%2 == 0){
            return false;
        }

        int maxFactor = (int) Math.floor(Math.sqrt(n));

        for(int i=3; i<=maxFactor; i+=2){
            if (n%i == 0){
                return false;
            }
        }

        return true;
    }
}
