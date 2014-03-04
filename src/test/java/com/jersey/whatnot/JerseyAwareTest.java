package com.jersey.whatnot;

import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.client.WebTarget;

import static com.jersey.whatnot.app.GrizzlyServer.BASE_URI;
import static com.jersey.whatnot.app.GrizzlyServer.startServer;
import static javax.ws.rs.client.ClientBuilder.newClient;

public class JerseyAwareTest {
    protected static HttpServer server;
    protected static WebTarget target;

    static {
        server = startServer();
        target = newClient().target(BASE_URI);
    }
}
