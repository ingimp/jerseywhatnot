package com.jersey.whatnot;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirtyWordDetectorResourceTest extends JerseyAwareTest {
    @Test
    public void should_detect_dirty_word() {
        Boolean isDirty = target.path("dirtyworddetector")
                .queryParam("word1", "hello")
                .queryParam("word2", "hi")
                .queryParam("word3", "hola")
                .queryParam("word4", "fuck")
                .request().get(Boolean.class);

        assertTrue(isDirty);
    }

    @Test
    public void should_not_detect_dirty_word_when_no_dirty_words_exist() {
        Boolean isDirty = target.path("dirtyworddetector")
                .queryParam("word1", "hello")
                .queryParam("word2", "hi")
                .queryParam("word3", "hola")
                .queryParam("word4", "hey")
                .request().get(Boolean.class);

        assertFalse(isDirty);
    }
}
