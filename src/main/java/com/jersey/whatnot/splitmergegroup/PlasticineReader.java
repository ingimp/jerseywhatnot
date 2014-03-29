package com.jersey.whatnot.splitmergegroup;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlasticineReader {
    public List<PlasticineEntity> readPlasticines() {
        return session("/postgres.cfg.xml").createQuery("from PlasticineEntity").list();
    }

    private Session session(final String resource) {
        Configuration configuration = new Configuration().configure(resource);
        Session session = configuration
                .buildSessionFactory(
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build())
                .openSession();
        session.beginTransaction();
        return session;
    }
}
