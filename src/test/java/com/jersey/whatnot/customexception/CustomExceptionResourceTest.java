package com.jersey.whatnot.customexception;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomExceptionResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig()
                .register(CustomExceptionResource.class)
                .register(MyExceptionProvider.class);
    }

    @Test
    public void exception_should_be_translated_into_response() throws Exception {
        Response resp = target("customexception").request().get();
        assertThat(resp.getStatus(), is(502));
        assertThat(resp.readEntity(String.class), is("oops"));
    }
}
