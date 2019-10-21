package com.simscale.task.data_access_layer.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PRIMES_REQUESTS", schema = "PNGDB")
public class PrimesRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;
    @Column(name = "FROM_INT")
    private Integer fromInt;
    @Column(name = "TO_INT")
    private Integer toInt;
    @Column(name = "TIME")
    private Float time;
    @Column(name = "STRATEGY")
    private String Strategy;
    @Column(name = "PRIMES_NO")
    private Integer primesNo;

    public PrimesRequest() {
    }

    public PrimesRequest(Timestamp timestamp, Integer fromInt, Integer toInt, Float time, String strategy, Integer primesNo) {
        this.timestamp = timestamp;
        this.fromInt = fromInt;
        this.toInt = toInt;
        this.time = time;
        Strategy = strategy;
        this.primesNo = primesNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getFromInt() {
        return fromInt;
    }

    public void setFromInt(Integer fromInt) {
        this.fromInt = fromInt;
    }

    public Integer getToInt() {
        return toInt;
    }

    public void setToInt(Integer toInt) {
        this.toInt = toInt;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public String getStrategy() {
        return Strategy;
    }

    public void setStrategy(String strategy) {
        Strategy = strategy;
    }

    public Integer getPrimesNo() {
        return primesNo;
    }

    public void setPrimesNo(Integer primesNo) {
        this.primesNo = primesNo;
    }
}
