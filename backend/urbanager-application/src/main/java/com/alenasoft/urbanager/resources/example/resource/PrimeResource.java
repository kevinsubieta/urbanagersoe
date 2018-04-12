package com.alenasoft.urbanager.resources.example.resource;

import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeSeriesServ;
import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeServ;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class PrimeResource {
    static String OK = "OK";
    static String FAIL = "FAIL";

    @Inject
    private PrimeServ service;

    @Inject
    private PrimeSeriesServ serieService;

    @GET
    @Path("primo/{entero}")
    public Response getResultOfSumById(@PathParam("entero") int entero) {
        if (this.service.numberIntegerIsPrime(entero))
            return Response.ok(OK).build();
        return Response.ok(FAIL).build();
    }

    @GET
    @Path("primo/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFirstNPrime(@QueryParam("limite") int limite) {
        int[] list =  this.serieService.getNFirstNumberPrimeSeries(limite);
        return Response.ok(list).build();
    }

}
