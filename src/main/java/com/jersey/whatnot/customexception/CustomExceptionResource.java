package com.jersey.whatnot.customexception;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/customexception")
public class CustomExceptionResource {
    @GET
    public Response handleCustomException() {
        throw new MyException("oops");
    }
}
