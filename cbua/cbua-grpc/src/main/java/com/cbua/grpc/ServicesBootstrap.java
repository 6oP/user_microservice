package com.cbua.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ServicesBootstrap {

    private static final Logger log = LoggerFactory.getLogger(ServicesBootstrap.class);

    private final GrpcServer grpcServer;

    public ServicesBootstrap(GrpcServer grpcServer) {
        this.grpcServer = grpcServer;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startGrpcServer() throws IOException {
        log.info("Starting grpc server");
        grpcServer.start();
        log.info("Server start completer");
    }
}
