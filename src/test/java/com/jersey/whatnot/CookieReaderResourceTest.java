package com.jersey.whatnot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CookieReaderResourceTest extends JerseyAwareTest {
    @Test
    public void should_read_cookie() throws Exception {
        String cookieReaderResponse = target.path("cookiereader")
                .request()
                .cookie("abc", "def")
                .get(String.class);

        assertThat(cookieReaderResponse, is("def"));
        //curl --cookie "abc=Yes" http://localhost:8080/myapp/cookiereader
    }
}
