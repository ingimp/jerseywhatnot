package com.jersey.whatnot.octetasjson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/octet")
public class OctetResource {
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public String octet() {
        return "{\"a\" : \"b\"}";
    }
}
