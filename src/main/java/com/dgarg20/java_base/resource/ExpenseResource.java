package com.dgarg20.java_base.resource;



import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Metric;
import com.codahale.metrics.annotation.Timed;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/expense")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
@NoArgsConstructor
public class ExpenseResource {
    @GET
    @Timed

    public Response getExpenseByID(@QueryParam("id") int id){
        log.info("Hello How are you");

        return Response.ok().build();
    }
}
