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
        System.out.println("got request at: " + Thread.currentThread().getId());
        expensiveComputation();
        System.out.println("computation done");
        return "sync call finished";
    }

    @GET
    @Path("async-call")
    public void asyncCall(@Suspended final AsyncResponse asyncResponse) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                expensiveComputation();
                asyncResponse.resume("async call finished");
                System.out.println("resumed");
            }
        }).start();
        System.out.println("got request at: " + Thread.currentThread().getId());
    }

    private void expensiveComputation() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
