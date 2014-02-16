package com.jersey.whatnot;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

import static org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer;

public class GrizzlyServer {

    public static final String BASE_URI = "http://localhost:8080/myapp/";
    public static final Class<JacksonFeature> registeredClasses = JacksonFeature.class;

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.jersey.whatnot")
                .registerClasses(registeredClasses);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();

        server.shutdownNow();
    }
}
