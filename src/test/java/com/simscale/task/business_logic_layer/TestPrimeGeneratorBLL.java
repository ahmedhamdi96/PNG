package com.simscale.task.business_logic_layer;

import com.simscale.task.business_logic_layer.strategies.SieveStrategy;
import com.simscale.task.business_logic_layer.strategies.Strategy1;
import com.simscale.task.business_logic_layer.strategies.Strategy2;
import com.simscale.task.business_logic_layer.strategies.Strategy3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPrimeGeneratorBLL {

    @Test
    void testStrategy1() {
        Integer from = 1;
        Integer to = 10;

        ArrayList<Integer> primesTrue = new ArrayList<Integer>();
        primesTrue.add(2);
        primesTrue.add(3);
        primesTrue.add(5);
        primesTrue.add(7);

        ArrayList<Integer> primes = new Strategy1().generatePrimes(from, to);

        assertEquals(primesTrue.size(), primes.size());

        for (int i=0; i<primes.size(); i++){
            assertEquals(primesTrue.get(i), primes.get(i));
        }
    }

    @Test
    void testStrategy2() {
        Integer from = 1;
        Integer to = 10;

        ArrayList<Integer> primesTrue = new ArrayList<Integer>();
        primesTrue.add(2);
        primesTrue.add(3);
        primesTrue.add(5);
        primesTrue.add(7);

        ArrayList<Integer> primes = new Strategy2().generatePrimes(from, to);

        assertEquals(primesTrue.size(), primes.size());

        for (int i=0; i<primes.size(); i++){
            assertEquals(primesTrue.get(i), primes.get(i));
        }
    }

    @Test
    void testStrategy3() {
        Integer from = 1;
        Integer to = 10;

        ArrayList<Integer> primesTrue = new ArrayList<Integer>();
        primesTrue.add(2);
        primesTrue.add(3);
        primesTrue.add(5);
        primesTrue.add(7);

        ArrayList<Integer> primes = new Strategy3().generatePrimes(from, to);

        assertEquals(primesTrue.size(), primes.size());

        for (int i=0; i<primes.size(); i++){
            assertEquals(primesTrue.get(i), primes.get(i));
        }
    }

    @Test
    void testSieveStrategy() {
        Integer from = 1;
        Integer to = 10;

        ArrayList<Integer> primesTrue = new ArrayList<Integer>();
        primesTrue.add(2);
        primesTrue.add(3);
        primesTrue.add(5);
        primesTrue.add(7);

        ArrayList<Integer> primes = new SieveStrategy().generatePrimes(from, to);

        assertEquals(primesTrue.size(), primes.size());

        for (int i=0; i<primes.size(); i++){
            assertEquals(primesTrue.get(i), primes.get(i));
        }
    }
}
