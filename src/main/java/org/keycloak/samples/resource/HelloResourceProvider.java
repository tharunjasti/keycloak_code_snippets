package org.keycloak.samples.resource;

/*import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;*/
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.UUID;

import static org.keycloak.samples.resource.KeycloakFilter.TRACE_ID_HEADER;

@Slf4j
public class HelloResourceProvider implements RealmResourceProvider {


    private static final Logger logger = LoggerFactory.getLogger(HelloResourceProvider.class);
    private KeycloakSession session;

    public HelloResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return this;
    }

    @GET
    @Path("/health")
    @Produces("text/plain; charset=utf-8")
    public String get() {
       /* String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID_HEADER, traceId);
        org.slf4j.MDC.put(TRACE_ID_HEADER, traceId);*/
        logger.info("health invoked");

        String name = session.getContext().getRealm().getDisplayName();
        if (name == null) {
            name = session.getContext().getRealm().getName();
        }
 /*       MDC.remove(TRACE_ID_HEADER);
        org.slf4j.MDC.remove(TRACE_ID_HEADER);*/
        return "Hello " + name+ org.slf4j.MDC.get(TRACE_ID_HEADER);
    }

    @Override
    public void close() {
    }
}
