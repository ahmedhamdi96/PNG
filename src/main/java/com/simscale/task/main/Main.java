package com.simscale.task.main;

import com.simscale.task.business_logic_layer.PrimeGeneratorBLL;
import com.simscale.task.dtos.PrimeResponseDTO;
import com.simscale.task.enums.PrimeStrategyEnum;
import com.simscale.task.rest.PrimeGeneratorEndpoint;

import java.util.ArrayList;

public class Main {

  private static PrimeGeneratorEndpoint primeGeneratorEndpoint= new PrimeGeneratorEndpoint();
  private static PrimeGeneratorBLL primeGeneratorBLL= new PrimeGeneratorBLL();

  public static void main(String[] args) {
    try{
      Integer from = Integer.valueOf(args[0]);
      Integer to = Integer.valueOf(args[1]);
      String strategy = args[2];
      primeGeneratorEndpoint.verifyInput(from, to, strategy);
      PrimeStrategyEnum primeStrategyEnum = primeGeneratorEndpoint.strategyStringToEnum(strategy);

      Long start = System.currentTimeMillis();
      ArrayList<Integer> primes = primeGeneratorBLL.primeStrategyGenerate(from, to, primeStrategyEnum);
      Long finish = System.currentTimeMillis();

      Float time = (finish - start) / 1000F;
      Integer primesNo = primes.size();

      PrimeResponseDTO primeResponseDTO = new PrimeResponseDTO(primesNo + " prime numbers generated.", time, primes);
      System.out.println(primeResponseDTO);
    } catch (IllegalArgumentException e){
        PrimeResponseDTO primeResponseDTO = new PrimeResponseDTO(e.getMessage(), null, null);
        System.out.println(primeResponseDTO);
    } catch (Exception e) {
        String msg = "Something went wrong! Contact development team.";
        PrimeResponseDTO primeResponseDTO = new PrimeResponseDTO(msg, null, null);
        System.out.println(primeResponseDTO);
    }
  }
}
