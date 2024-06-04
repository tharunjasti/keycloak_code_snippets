package org.keycloak.samples.resource;


import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@Slf4j
@ApplicationScoped
public class ApplicationLifeCycle  {


    private static final Logger logger = LoggerFactory.getLogger(ApplicationLifeCycle.class);



    void onStart(@Observes StartupEvent ev) {
        logger.info("Application is started, current timetsmap is ::"+System.currentTimeMillis());

    }

    void onStop(@Observes ShutdownEvent ev) {
        logger.info("The application is stopping...");
    }
}