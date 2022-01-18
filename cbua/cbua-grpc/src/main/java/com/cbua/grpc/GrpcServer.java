package com.cbua.grpc;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

@Component
public class GrpcServer implements Closeable {

    private static final Logger log = LoggerFactory.getLogger(GrpcServer.class);

    private final List<ServerServiceDefinition> services;

    private final ServerBuilder<?> serverBuilder;
    private final GrpcServerConfig grpcServerConfig;


    private Server server;

    public GrpcServer(List<ServerServiceDefinition> services, GrpcServerConfig grpcServerConfig) {
        this.services = services;
        this.grpcServerConfig = grpcServerConfig;
        serverBuilder = ServerBuilder.forPort(grpcServerConfig.getPort());
    }

    @PostConstruct
    private void init() {
        log.info("Initialize gRPC server");
        addServices();
    }

    private void addServices() {
        services.forEach(serverServiceDefinition -> {
            log.info("Adding service '{}'", serverServiceDefinition.getServiceDescriptor().getName());
            serverBuilder.addService(serverServiceDefinition);
        });
    }

    public void start() throws IOException {
        server = serverBuilder.build();
        server.start();
    }

    @Override
    public void close() {
        log.info("Shutting down gRPC server");
        server.shutdown();
    }
}
