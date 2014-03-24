package com.jersey.whatnot.ormappingspike;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class DoNotMapRelationTableSpikeTest {
    @Test
    public void do_we_really_have_to_map_the_relation_as_entity() throws Exception {
        Session localPostgresSession = session("/spike.cfg.xml");
        tryReadFourTables(localPostgresSession);
    }

    private void tryReadFourTables(Session localPostgresSession) {
        read(localPostgresSession, DcEntity.class);
        read(localPostgresSession, VEntity.class);
        read(localPostgresSession, IEntity.class);
    }

    private void read(Session localPostgresSession, Class<?> persistentClass) {
        System.out.println(localPostgresSession.createCriteria(persistentClass).list());
    }

    public static Session session(final String resource) {
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
