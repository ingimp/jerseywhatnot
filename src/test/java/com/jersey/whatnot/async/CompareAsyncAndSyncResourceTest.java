package com.jersey.whatnot.async;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompareAsyncAndSyncResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig().register(CompareAsyncAndSyncResource.class);
    }

    @Test
    public void sync_call_should_take_longer() throws Exception {
        final Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        callManyTimes(new Runnable() {
            @Override
            public void run() {
                System.out.println("sending request");
                String resp = target("async-sync/sync-call").request().get().readEntity(String.class);
                System.out.println("sync returned " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
                assertThat(resp, is("sync call finished"));
            }
        });

        stopwatch.stop();

        System.out.println("five clients calling sync get at same time " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void async_call_should_take_shorter() throws Exception {
        final Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        callManyTimes(new Runnable() {
            @Override
            public void run() {
                System.out.println("sending request");
                String resp = target("async-sync/async-call").request().get().readEntity(String.class);
                System.out.println("async returned " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
                assertThat(resp, is("async call finished"));
            }
        });

        stopwatch.stop();

        System.out.println("five clients calling async get at same time " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    private void callManyTimes(final Runnable runnable) throws InterruptedException {
        Iterable<Integer> range = newArrayList(ContiguousSet
                .create(Range.closed(1, 80), DiscreteDomain.integers()));

        List<Thread> threads = from(range).transform(new Function<Integer, Thread>() {
            @Override
            public Thread apply(Integer number) {
                Thread thread = new Thread(runnable);
                thread.start();
                return thread;
            }
        }).toList();

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
