package com.alenasoft.urbanager.resources.example.resource;

import com.alenasoft.urbanager.resources.example.service.Interfaces.PrimeServ;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("primo")
public class PrimeResource {
    static String OK = "OK";
    static String FAIL = "FAIL";

    @Inject
    private PrimeServ service;

    @GET
    @Path("{entero}")
    public Response getResultOfSumById(@PathParam("entero") int entero) {
        if (this.service.numberIntegerIsPrime(entero))
            return Response.ok(OK).build();
        return Response.ok(FAIL).build();
    }

}
