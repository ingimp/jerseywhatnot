package com.jersey.whatnot;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cookiereader")
public class CookieReaderResource {
    @GET
    public String readCookie(@CookieParam("abc") String abc) {
        return abc;
    }
}

