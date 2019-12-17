package com.dgarg20.java_base.application_manager.filters;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

@Provider
@PreMatching
@Slf4j
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        MDC.put("trans.id", UUID.randomUUID().toString());
        log.info("{} {} \nheaders: {}, body: {}", ctx.getMethod(), ctx.getUriInfo().getAbsolutePath().getQuery(), ctx.getHeaders(), ctx.getEntityStream());

        if (ctx.getMethod().equals("DELETE")) {
           // LOG.info("\"Deleting request");
        }
    }
}