package com.simscale.task.business_logic_layer.strategies;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public abstract class PrimeStrategyThread extends Thread {

    private Integer from;
    private Integer to;
    private ArrayList<Integer> primes;
    private final static Logger LOGGER = Logger.getLogger(PrimeStrategyThread.class);

    public PrimeStrategyThread(String name, Integer from, Integer to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

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

    public void run(){
        LOGGER.info(this.getName() + " is running.");
        this.primes = generatePrimes(this.from, this.to);
    }
}
