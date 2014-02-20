package com.jersey.whatnot.subresource;

import com.jersey.whatnot.JerseyAwareTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubResourceTest extends JerseyAwareTest {
    @Test
    public void should_direct_to_subresource() throws Exception {
        int status = target.path("/a/b").request().get().getStatus();
        assertThat(status, is(200));
    }
}
