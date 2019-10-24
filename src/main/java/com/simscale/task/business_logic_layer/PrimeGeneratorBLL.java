package com.simscale.task.business_logic_layer;

import com.simscale.task.business_logic_layer.strategies.*;
import com.simscale.task.enums.PrimeStrategyEnum;
import com.simscale.task.data_access_layer.PrimeGeneratorDAL;
import com.simscale.task.dtos.PrimeResponseDTO;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.ArrayList;

import static com.simscale.task.business_logic_layer.thread_management.ThreadManagement.runThreads;

@Stateless
public class PrimeGeneratorBLL {

    @EJB
    private PrimeGeneratorDAL primeGeneratorDAL;
    private final static Logger LOGGER = Logger.getLogger(PrimeGeneratorBLL.class);

    /**
     * identify which strategy to use based on strategy enum
     * @param from natural number to start with
     * @param to natural number to end with
     * @param primeStrategyEnum strategy enum
     * @return primes list
     */
    public ArrayList<Integer> primeStrategyGenerate (Integer from, Integer to, PrimeStrategyEnum primeStrategyEnum) throws InterruptedException {
        switch (primeStrategyEnum){
            case STRATEGY_1:
            case STRATEGY_2:
            case STRATEGY_3: return runThreads(from, to, primeStrategyEnum);
            case SIEVE_STRATEGY: return new SieveStrategy().generatePrimes(from, to);
            default: return null;
        }
    }

    /**
     * generate primes list based on strategy enum
     * @param from natural number to start with
     * @param to natural number to end with
     * @param primeStrategyEnum strategy enum
     * @return a DTO containing a message(str) and primes(list of integers)
     */
    public PrimeResponseDTO generatePrimeNumbers(Integer from, Integer to, PrimeStrategyEnum primeStrategyEnum) throws InterruptedException {
        LOGGER.info("generatePrimeNumbers: ENTER");
        Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
        String strategy  =  primeStrategyEnum.name().toLowerCase();

        LOGGER.info("generatePrimeNumbers: [timestamp: "+timestamp+", from: "+from+", to: "+to+", strategy: "+strategy+"]");

        Long start = System.currentTimeMillis();
        ArrayList<Integer> primes = primeStrategyGenerate(from, to, primeStrategyEnum);
        Long finish = System.currentTimeMillis();

        Float time = (finish - start) / 1000F;
        Integer primesNo = primes.size();

        primeGeneratorDAL.addRecord(timestamp, from, to, time,strategy, primesNo);

        LOGGER.info("generatePrimeNumbers: EXIT");
        return new PrimeResponseDTO(primesNo + " prime number(s) generated.", time, primes);
    }
}
