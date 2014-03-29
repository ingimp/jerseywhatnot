package com.jersey.whatnot.ormappingspike;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OrMappingSpikeTest {
    protected Session session(final String resource) {
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
