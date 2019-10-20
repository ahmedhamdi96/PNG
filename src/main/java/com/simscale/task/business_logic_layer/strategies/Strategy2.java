package com.simscale.task.business_logic_layer.strategies;

import com.simscale.task.business_logic_layer.interfaces.PrimeStrategyInterface;

import java.util.ArrayList;

public class Strategy2 implements PrimeStrategyInterface {

    @Override
    public ArrayList<Integer> generatePrimes(Integer from, Integer to) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        return list;
    }
}
