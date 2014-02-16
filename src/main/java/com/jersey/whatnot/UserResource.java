package com.jersey.whatnot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users/{username}")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("username") String userName) {
        return "whatever your name is, " + userName + ", i am responding this message.";
    }
}
