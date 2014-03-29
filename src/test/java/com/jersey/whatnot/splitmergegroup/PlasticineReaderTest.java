package com.jersey.whatnot.splitmergegroup;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlasticineReaderTest {
    @Test
    public void should_read_plasticines() throws Exception {
        List<PlasticineEntity> plasticineEntities = new PlasticineReader().readPlasticines();
        assertTrue(plasticineEntities.size() > 0);
    }
}
