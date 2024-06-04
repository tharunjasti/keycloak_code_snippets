package org.keycloak.samples.resource;

/*import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;*/
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.ext.Provider;

import javax.ws.rs.container.*;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@Provider
public class KeycloakFilter  implements ContainerRequestFilter, ContainerResponseFilter {

    public static final String TRACE_ID_HEADER = "X-Request-ID";
    private static final Logger log = LoggerFactory.getLogger(KeycloakFilter.class);


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String traceId = UUID.randomUUID().toString();
        MDC.put(TRACE_ID_HEADER, traceId);
        org.slf4j.MDC.put(TRACE_ID_HEADER, traceId);
        log.info("ContainerRequestContext invoked");
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

        MDC.remove(TRACE_ID_HEADER);
        org.slf4j.MDC.remove(TRACE_ID_HEADER);
        log.info("ContainerRequestContext invoked");
    }

}
