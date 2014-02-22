package com.jersey.whatnot.injectionexample;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/cdibean")
public class WhatEverResource {
    @Inject
    private WhatEverService whateverService;

    public WhatEverResource() {
        System.out.println("constructor called");
    }

    @GET
    @Produces("text/plain")
    public String getIt() {
        return whateverService.getIt();
    }
}