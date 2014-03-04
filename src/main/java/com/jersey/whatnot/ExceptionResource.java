package com.jersey.whatnot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/webapplicationexception")
public class ExceptionResource {
    @GET
    public Response handleException() {
        throw new WebApplicationException(Response.status(404).
                entity("something wrong").type("text/plain").build());
    }
}
