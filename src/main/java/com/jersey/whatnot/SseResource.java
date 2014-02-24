package com.jersey.whatnot;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("events")
public class SseResource {

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() throws IOException, InterruptedException {
        final EventOutput eventOutput = new EventOutput();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        eventOutput.write(createEvent("message", i.toString()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        //keep the connection alive
        return eventOutput;
    }

    private OutboundEvent createEvent(String name, String data) {
        return new OutboundEvent.Builder()
                .name(name).data(String.class, data)
                .build();
    }
}
