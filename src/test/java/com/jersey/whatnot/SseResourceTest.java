package com.jersey.whatnot;

import com.google.common.base.Stopwatch;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.TimeUnit;

public class SseResourceTest extends JerseyAwareTest {
    @Test
    public void should_keep_connection_alive_until_closed_by_client() throws Exception {
        Client client = ClientBuilder.newBuilder()
                .register(SseFeature.class).build();
        WebTarget target = client.target("http://localhost:8080/myapp/events");

        EventSource eventSource = EventSource.target(target).build();
        EventListener listener = new EventListener() {
            @Override
            public void onEvent(InboundEvent inboundEvent) {
                System.out.println(inboundEvent.getName() + "; "
                        + inboundEvent.readData(String.class));
            }
        };
        eventSource.register(listener, "message");

        eventSource.open();
        Stopwatch stopwatch = new Stopwatch().start();
        while (stopwatch.elapsed(TimeUnit.SECONDS) < 15) {
        }
    }
}
