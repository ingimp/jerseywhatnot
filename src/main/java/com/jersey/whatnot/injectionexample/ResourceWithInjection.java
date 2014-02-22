package com.jersey.whatnot.injectionexample;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/cdibean")
public class ResourceWithInjection {
    @Inject
    private IWillBeInjected injectedObj;

    public ResourceWithInjection() {
        System.out.println("constructor called");
    }

    @GET
    @Produces("text/plain")
    public String getIt() {
        return injectedObj.getIt();
    }
}