package com.simscale.task.business_logic_layer;

import com.simscale.task.enums.PrimeStrategyEnum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPrimeGeneratorBLL {

    PrimeGeneratorBLL primeGeneratorBLL = new PrimeGeneratorBLL();

    @Test
    void testStrategy1 () {
        try {
            Integer from = 1;
            Integer to = 10;

            ArrayList<Integer> primesTrue = new ArrayList<Integer>();
            primesTrue.add(2);
            primesTrue.add(3);
            primesTrue.add(5);
            primesTrue.add(7);

            ArrayList<Integer> primes = primeGeneratorBLL.primeStrategyGenerate(from, to, PrimeStrategyEnum.STRATEGY_1);

            assertEquals(primesTrue.size(), primes.size());

            for (int i=0; i<primes.size(); i++){
                assertEquals(primesTrue.get(i), primes.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            assertEquals(null, e);
        }
    }

    @Test
    void testStrategy2() {
        try {
            Integer from = 1;
            Integer to = 10;

            ArrayList<Integer> primesTrue = new ArrayList<Integer>();
            primesTrue.add(2);
            primesTrue.add(3);
            primesTrue.add(5);
            primesTrue.add(7);

            ArrayList<Integer> primes = primeGeneratorBLL.primeStrategyGenerate(from, to, PrimeStrategyEnum.STRATEGY_2);

            assertEquals(primesTrue.size(), primes.size());

            for (int i=0; i<primes.size(); i++){
                assertEquals(primesTrue.get(i), primes.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            assertEquals(null, e);
        }
    }

    @Test
    void testStrategy3() {
        try {
            Integer from = 1;
            Integer to = 10;

            ArrayList<Integer> primesTrue = new ArrayList<Integer>();
            primesTrue.add(2);
            primesTrue.add(3);
            primesTrue.add(5);
            primesTrue.add(7);

            ArrayList<Integer> primes = primeGeneratorBLL.primeStrategyGenerate(from, to, PrimeStrategyEnum.STRATEGY_3);

            assertEquals(primesTrue.size(), primes.size());

            for (int i=0; i<primes.size(); i++){
                assertEquals(primesTrue.get(i), primes.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            assertEquals(null, e);
        }
    }

    @Test
    void testSieveStrategy() {
        try{

            Integer from = 1;
            Integer to = 10;

            ArrayList<Integer> primesTrue = new ArrayList<Integer>();
            primesTrue.add(2);
            primesTrue.add(3);
            primesTrue.add(5);
            primesTrue.add(7);

            ArrayList<Integer> primes = primeGeneratorBLL.primeStrategyGenerate(from, to, PrimeStrategyEnum.SIEVE_STRATEGY);

            assertEquals(primesTrue.size(), primes.size());

            for (int i=0; i<primes.size(); i++){
                assertEquals(primesTrue.get(i), primes.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            assertEquals(null, e);
        }
    }
}
