package com.simscale.task.data_access_layer;

import com.simscale.task.data_access_layer.entities.PrimesRequest;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

@Stateless
public class PrimeGeneratorDAL {

    @PersistenceContext(unitName = "pngdb-pu")
    private EntityManager entityManager;
    private final static Logger LOGGER = Logger.getLogger(PrimeGeneratorDAL.class);

    public void addRecord(Timestamp timestamp, Integer fromInt, Integer toInt, Float time, String strategy, Integer primesNo){
        LOGGER.info("addRecord: ENTER");
        PrimesRequest primesRequest = new PrimesRequest(timestamp, fromInt, toInt, time, strategy, primesNo);
        entityManager.persist(primesRequest);
        LOGGER.info("addRecord: EXIT");
    }
}
