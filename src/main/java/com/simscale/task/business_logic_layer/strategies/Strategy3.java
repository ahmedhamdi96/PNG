package com.simscale.task.business_logic_layer.strategies;

import com.simscale.task.business_logic_layer.interfaces.PrimeStrategyInterface;

import java.util.ArrayList;

public class Strategy3 implements PrimeStrategyInterface {

    @Override
    public ArrayList<Integer> generatePrimes(Integer from, Integer to) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(8);
        return list;
    }
}
