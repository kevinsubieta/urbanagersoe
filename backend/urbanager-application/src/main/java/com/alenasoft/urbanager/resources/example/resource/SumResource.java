package com.alenasoft.urbanager.resources.example.resource;

import com.alenasoft.urbanager.api.Result;
import com.alenasoft.urbanager.resources.example.service.Interfaces.SumService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("hello")
public class SumResource {

    @Inject
    private SumService service;

    @GET
    public String helloWorld() {
        return "Hello World";
    }

    @GET
    @UnitOfWork
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result getResultOfSumById(@PathParam("id") long id) {
        return this.service.getResultOfSumById(id);
    }

    @GET
    @Path("query")
    public String helloWorldQuery(@QueryParam("data") String data,
                                  @QueryParam("second") String second) {
        return String.join(data,second);
    }

    @GET
    @UnitOfWork
    @Path("{num1}/{num2}")
    public Response sumTwoNumbersIntegers(@PathParam("num1") int num1,
                               @PathParam("num2") int num2) {
        long idCreated = this.service.sumTwoNumbersIntegers(num1, num2);
        String uriString = String.format("/api/hello/%s", idCreated);
        return Response
                .created(URI.create(uriString))
                //.entity(this.service.sum(num1, num2))
                .build();
    }
}

