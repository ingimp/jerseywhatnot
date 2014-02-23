package com.jersey.whatnot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParamAggregationResourceTest extends JerseyAwareTest {
    @Test
    public void should_aggregate_parameters() throws Exception {
        String aggResp = target.path("paramagg")
                .queryParam("qp1", "a")
                .queryParam("qp2", "b")
                .request()
                .cookie("cp1", "c")
                .header("hp1", "d")
                .get(String.class);

        assertThat(aggResp, is("a,b,c,d"));
        //curl --cookie "cp1=fromcookie" -H "somethinginheader:thisisthevalue" http://localhost:8080/myapp/paramagg?qp1=fromqueryparameter&qp2=whatever
    }
}
