package com.simscale.task.rest;


import com.simscale.task.business_logic_layer.PrimeGeneratorBLL;
import com.simscale.task.dtos.PrimeResponseDTO;
import com.simscale.task.enums.PrimeStrategyEnum;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/prime")
public class PrimeGeneratorEndpoint {

	@EJB
	private PrimeGeneratorBLL primeGeneratorBLL;
	private final static Logger LOGGER = Logger.getLogger(PrimeGeneratorEndpoint.class);

	private PrimeStrategyEnum doGetInputVerification(Integer from, Integer to, String strategy){
		if (from == null || to == null || strategy == null){
			throw new IllegalArgumentException("The query params (from, to, strategy) are required!");
		}

		if (from <= 0 || to <= 0){
			throw new IllegalArgumentException("Query params from and to should start from 1!");
		}

		if (to < from) {
			throw new IllegalArgumentException("Query param to should be greater than or equal to query param from!");
		}

		for (PrimeStrategyEnum primeStrategyEnum : PrimeStrategyEnum.values()) {
			if (primeStrategyEnum.name().equalsIgnoreCase(strategy))
				return primeStrategyEnum;
		}
		String msg = "Invalid strategy! Valid strategies are (strategy_1, strategy_2, strategy_3, sieve_strategy)";
		throw new IllegalArgumentException(msg);
	}

	@GET
	public Response doGet(
			@QueryParam("from") Integer from,
			@QueryParam("to") Integer to,
			@QueryParam("strategy") String strategy) {

		try {
			LOGGER.info("doGet: ENTER");
			PrimeStrategyEnum primeStrategyEnum = doGetInputVerification(from, to, strategy);
			PrimeResponseDTO primeResponseDTO = primeGeneratorBLL.generatePrimeNumbers(from, to, primeStrategyEnum);
			LOGGER.info("doGet: EXIT");
			return Response.ok().entity(primeResponseDTO).build();
		} catch (IllegalArgumentException e){
			LOGGER.error(e.getMessage(), e);
			PrimeResponseDTO primeResponseDTO = new PrimeResponseDTO(e.getMessage(), null);
			return Response.status(Response.Status.BAD_REQUEST).entity(primeResponseDTO).build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			String msg = "Something went wrong! Contact development team.";
			PrimeResponseDTO primeResponseDTO = new PrimeResponseDTO(msg, null);
			return Response.serverError().entity(primeResponseDTO).build();
		}
	}
}
