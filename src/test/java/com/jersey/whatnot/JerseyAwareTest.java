package com.jersey.whatnot;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import static com.jersey.whatnot.GrizzlyServer.BASE_URI;
import static com.jersey.whatnot.GrizzlyServer.startServer;
import static javax.ws.rs.client.ClientBuilder.newClient;

public class JerseyAwareTest {
    protected HttpServer server;
    protected WebTarget target;

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
}
