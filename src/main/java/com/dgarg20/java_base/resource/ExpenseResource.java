package com.dgarg20.java_base.resource;


import com.codahale.metrics.annotation.Timed;
import com.dgarg20.java_base.dtos.Expense;
import com.dgarg20.java_base.exceptions.TempException;
import com.dgarg20.java_base.requests.AddExpense;
import com.dgarg20.java_base.response.SummaryResponse;
import com.dgarg20.java_base.service.ExpenseService;
import com.dgarg20.java_base.service.GroupService;
import com.google.inject.Inject;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/expense")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
@NoArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
public class ExpenseResource {
    private ExpenseService expenseService;

    @Inject
    public ExpenseResource(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @POST
    public Response createExpense(@HeaderParam("X-CURRENT-USER") String currentUser,
                                  AddExpense addExpense) {
        try {
            expenseService.addExpense(addExpense, currentUser);
            return Response.ok().build();
        }
        catch (TempException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
        }
        catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/users/{id}")
    public Response getUserSplitwise(@PathParam("id") int userId) {
        try {
            return Response.ok().entity(expenseService.getSummary(userId)).build();
        }
//        catch (TempException ex) {
//            return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
//        }
        catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
