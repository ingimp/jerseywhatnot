package com.jersey.whatnot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyResourceTest extends JerseyAwareTest {

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}
