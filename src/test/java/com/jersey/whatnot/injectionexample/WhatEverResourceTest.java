package com.jersey.whatnot.injectionexample;

import com.jersey.whatnot.JerseyAwareTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WhatEverResourceTest extends JerseyAwareTest {
    @Test
    public void should_inject_object_into_root_resource() throws Exception {
        String cdibeanResponse = target.path("cdibean").request().get(String.class);
        assertThat(cdibeanResponse, is("injection successfully done."));
    }
}
