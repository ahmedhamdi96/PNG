package com.simscale.task.business_logic_layer;

import com.simscale.task.enums.PrimeStrategyEnum;
import com.simscale.task.business_logic_layer.strategies.SieveStrategy;
import com.simscale.task.business_logic_layer.strategies.Strategy1;
import com.simscale.task.business_logic_layer.strategies.Strategy2;
import com.simscale.task.business_logic_layer.strategies.Strategy3;
import com.simscale.task.data_access_layer.PrimeGeneratorDAL;
import com.simscale.task.dtos.PrimeResponseDTO;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class PrimeGeneratorBLL {

    @EJB
    PrimeGeneratorDAL primeGeneratorDAL;
    private final static Logger LOGGER = Logger.getLogger(PrimeGeneratorBLL.class);

    private ArrayList<Integer> primeStrategyGenerate (Integer from, Integer to, PrimeStrategyEnum primeStrategyEnum){

        switch (primeStrategyEnum){
            case STRATEGY_1: return new Strategy1().generatePrimes(from, to);
            case STRATEGY_2: return new Strategy2().generatePrimes(from, to);
            case STRATEGY_3: return new Strategy3().generatePrimes(from, to);
            case SIEVE_STRATEGY: return new SieveStrategy().generatePrimes(from, to);
            default: return null;
        }
    }

    public PrimeResponseDTO generatePrimeNumbers(Integer from, Integer to, PrimeStrategyEnum primeStrategyEnum){
        LOGGER.info("generatePrimeNumbers: ENTER");
        ArrayList<Integer> primes = primeStrategyGenerate(from, to, primeStrategyEnum);
        LOGGER.info("generatePrimeNumbers: EXIT");
        return new PrimeResponseDTO(null, primes);
    }
}
