package com.jersey.whatnot;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import static com.jersey.whatnot.GrizzlyServer.BASE_URI;
import static com.jersey.whatnot.GrizzlyServer.startServer;
import static javax.ws.rs.client.ClientBuilder.newClient;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = startServer();

        Client client = newClient();
        target = client.target(BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}
