package com.jersey.whatnot;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Lists.newArrayList;

@Path("/brick")
public class ResourceUsingFormParameter {
    @POST
    public String handlePostToBrick(@FormParam("long") boolean isLong,
                                    @FormParam("thick") boolean isThick) {
        return on(" ")
                .join(newArrayList(
                        "ban zhuan chang ma?", isLong,
                        "ban zhuan hou ma?", isThick));
    }
}
