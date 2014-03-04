package com.jersey.whatnot;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExceptionResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig().register(ExceptionResource.class);
    }

    @Test
    public void exception_should_be_translated_into_response() throws Exception {
        Response resp = target("webapplicationexception").request().get();
        assertThat(resp.getStatus(), is(404));
        assertThat(resp.readEntity(String.class), is("something wrong"));
    }
}
