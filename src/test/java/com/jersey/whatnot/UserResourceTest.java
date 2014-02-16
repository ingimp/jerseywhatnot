package com.jersey.whatnot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserResourceTest extends JerseyAwareTest {
    @Test
    public void should_get_certain_message_for_a_username() {
        String user = target.path("users/whatever user name")
                .request()
                .get(String.class);

        assertThat(user, is("whatever your name is, whatever user name, i am responding this message."));
    }
}
