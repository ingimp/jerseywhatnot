package com.jersey.whatnot.subresource;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public class BResource {
    @GET
    public Response handleB() {
        return Response.ok().build();
    }
}
