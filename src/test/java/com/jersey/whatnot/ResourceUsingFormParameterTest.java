package com.jersey.whatnot;

import org.junit.Test;

import javax.ws.rs.core.Form;

import static javax.ws.rs.client.Entity.form;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResourceUsingFormParameterTest extends JerseyAwareTest {
    @Test
    public void should_respond_according_to_form_parameters() {
        //to test this: curl --data "long=false&thick=true" http://localhost:8080/myapp/brick
        String response = target.path("brick").request()
                .post(form(new Form()
                        .param("long", "true")
                        .param("thick", "false")), String.class);

        assertThat(response, is("ban zhuan chang ma? true ban zhuan hou ma? false"));
    }
}
