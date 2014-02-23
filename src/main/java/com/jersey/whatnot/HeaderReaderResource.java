package com.jersey.whatnot;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@Path("/headerreader")
public class HeaderReaderResource {
    @GET
    public String readHeader(@HeaderParam("somethinginheader") String something) {
        return something;
    }
}
