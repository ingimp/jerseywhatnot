package com.jersey.whatnot.octetasjson;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM_TYPE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OctetResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig().register(OctetResource.class);
    }

    @Override
    protected void configureClient(ClientConfig config) {
        super.configureClient(config);
        config.register(MyEntityProvider.class);
    }

    @Test
    public void should_be_able_to_read_octet_as_json() throws Exception {
        MyEntity octet = target("octet").request().get().readEntity(MyEntity.class);
        assertThat(octet.getA(), is("b"));
    }

    @Provider
    @Consumes(APPLICATION_OCTET_STREAM)
    private static class MyEntityProvider extends MOXyJsonProvider {
        @Override
        public boolean isReadable(Class<?> type, Type genericType,
                                  Annotation[] annotations, MediaType mediaType) {
            return type == MyEntity.class && mediaType.equals(APPLICATION_OCTET_STREAM_TYPE);
        }
    }

    @XmlRootElement
    private static class MyEntity {
        @XmlElement(name = "a")
        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}

