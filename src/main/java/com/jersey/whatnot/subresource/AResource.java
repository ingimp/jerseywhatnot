package com.jersey.whatnot.subresource;

import javax.ws.rs.Path;

@Path("/a")
public class AResource {
    @Path("/b")
    public BResource handleB() {
        return new BResource();
    }
}
