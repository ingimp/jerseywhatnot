package com.jersey.whatnot;

import com.google.common.base.Predicate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;

@Path("/dirtyworddetector")
public class DirtyWordDetectorResource {
    @GET
    public Boolean isDirty(@Context UriInfo uriInfo) {
        return from(uriInfo.getQueryParameters().values())
                .anyMatch(listIncludeDirty());
    }

    private Predicate<List<String>> listIncludeDirty() {
        return new Predicate<List<String>>() {
            @Override
            public boolean apply(List<String> input) {
                return from(input).anyMatch(stringIncludeDirty());
            }
        };
    }

    private Predicate<String> stringIncludeDirty() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return "fuck".equals(input);
            }
        };
    }
}
