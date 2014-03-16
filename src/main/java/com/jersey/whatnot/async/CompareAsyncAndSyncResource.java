package com.jersey.whatnot.async;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import static java.lang.Thread.sleep;

@Path("/async-sync")
public class CompareAsyncAndSyncResource {
    @GET
    @Path("sync-call")
    public String syncCall() throws InterruptedException {
        sleep(1000);
        return "sync call finished";
    }

    @GET
    @Path("async-call")
    public void asyncCall(@Suspended final AsyncResponse asyncResponse) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                asyncResponse.resume("async call finished");
            }
        }).start();
    }
}
