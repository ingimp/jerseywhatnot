package com.jersey.whatnot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HeaderReaderResourceTest extends JerseyAwareTest {
    @Test
    public void should_read_header() throws Exception {
        String headerReaderResponse = target.path("headerreader")
                .request()
                .header("somethinginheader", "thevalue")
                .get(String.class);

        assertThat(headerReaderResponse, is("thevalue"));

        //curl -X GET -H "somethinginheader:thisisthevalue" http://localhost:8080/myapp/headerreader
    }
}
