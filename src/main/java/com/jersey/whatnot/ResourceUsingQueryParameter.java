package com.jersey.whatnot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Lists.newArrayList;

@Path("/abc")
public class ResourceUsingQueryParameter {
    @GET
    public String getAbc(@QueryParam("a") String a,
                         @QueryParam("b") String b,
                         @QueryParam("c") String c) {
        return "query parameters are: " +
                on(" ").join(newArrayList(a, b, c));
    }
}
