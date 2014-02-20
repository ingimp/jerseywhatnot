package com.jersey.whatnot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResourceUsingQueryParameterTest extends JerseyAwareTest {
    //to test this in a browser: http://localhost:8080/myapp/abc?a=1&b=2&c=3
    @Test
    public void should_respond_according_to_query_parameters() {
        String abcResponse = target.path("abc")
                .queryParam("a", "hi")
                .queryParam("b", "hey")
                .queryParam("c", "hola")
                .request().get(String.class);

        assertThat(abcResponse, is("query parameters are: hi hey hola"));
    }
}
