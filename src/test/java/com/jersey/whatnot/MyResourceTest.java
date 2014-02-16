package com.jersey.whatnot;

import org.junit.Test;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import static javax.ws.rs.client.Entity.form;
import static javax.ws.rs.client.Entity.json;
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

    @Test
    public void put_should_take_form_param() {
        Response responseMsg = target.path("myresource")
                .request()
                .put(form(new Form()
                        .param("hey", "this is the greeting message!")));

        assertEquals(responseMsg.readEntity(String.class), "this is the greeting message!");
    }

    @Test
    public void consume_annotation_should_restrict_inbound_data() {
        Response responseMsg = target.path("myresource")
                .request()
                .post(json(new ClichesMsg(":)", ":(")));

        assertEquals(responseMsg.readEntity(String.class), ":) :(");
    }
}
