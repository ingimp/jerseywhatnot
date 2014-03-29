package com.jersey.whatnot.ormappingspike;

import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InsertIntoDcTest extends OrMappingSpikeTest {
    @Test
    public void should_insert_into_dc() throws Exception {
        Session h2Session = session("/spike.h2.cfg.xml");
        DcEntity dcEntity = new DcEntity();
        h2Session.save(dcEntity);
        h2Session.getTransaction().commit();
        List list = h2Session.createQuery("from DcEntity").list();
        System.out.println(list.get(0));
        assertThat(list.size(), is(1));
    }

    @Test
    public void should_insert2_into_dc() throws Exception {
        Session h2Session = session("/spike.h2.cfg.xml");
        DcEntity dcEntity = new DcEntity();
        h2Session.save(dcEntity);
        h2Session.getTransaction().commit();
        List list = h2Session.createQuery("from DcEntity").list();
        System.out.println(list.get(0));
        assertThat(list.size(), is(1));
    }
}
