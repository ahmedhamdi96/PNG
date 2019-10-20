package com.simscale.task.dtos;

import java.util.ArrayList;

public class PrimeResponseDTO {

    private String message;
    private ArrayList<Integer> primes;

    public PrimeResponseDTO(String message, ArrayList<Integer> primes) {
        this.message = message;
        this.primes = primes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(ArrayList<Integer> primes) {
        this.primes = primes;
    }
}
