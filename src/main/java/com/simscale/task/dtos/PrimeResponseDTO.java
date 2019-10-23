package com.simscale.task.dtos;

import java.util.ArrayList;

public class PrimeResponseDTO {

    private String message;
    private Float time;
    private ArrayList<Integer> primes;

    public PrimeResponseDTO() {
    }

    public PrimeResponseDTO(String message, Float time, ArrayList<Integer> primes) {
        this.message = message;
        this.time = time;
        this.primes = primes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(ArrayList<Integer> primes) {
        this.primes = primes;
    }

    private String primesToString(ArrayList<Integer> primes){
        if (primes == null){
            return "null";
        }

        StringBuilder s = new StringBuilder("[ ");

        for (Integer p:primes){
            s.append(p);
        }

        s.append("]");

        return s.toString();
    }

    @Override
    public String toString() {
        String time = this.time == null? "null":String.valueOf(this.time);

        return "{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", primes=" + primesToString(primes) +
                '}';
    }
}
