package com.jersey.whatnot;

import com.google.common.base.Joiner;

import javax.ws.rs.*;

@Path("/paramagg")
public class ParamAggregationResource {
    @GET
    public String aggregateParams(@BeanParam AggregatedParams params) {
        return params.toString();
    }

    private static class AggregatedParams {
        private AggregatedParams() {
        }

        @QueryParam("qp1")
        private String queryParam1;

        @QueryParam("qp2")
        private String queryParam2;

        @CookieParam("cp1")
        private String cookieParam1;

        @HeaderParam("hp1")
        private String headerParam1;

        @Override
        public String toString() {
            return Joiner.on(",").skipNulls().join(queryParam1, queryParam2, cookieParam1, headerParam1);
        }
    }
}
