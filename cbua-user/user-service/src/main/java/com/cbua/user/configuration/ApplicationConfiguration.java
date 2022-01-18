package com.cbua.user.configuration;

import com.cbua.user.avro.UserService;
import io.grpc.ServerServiceDefinition;
import org.apache.avro.grpc.AvroGrpcServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    private final UserService userService;

    public ApplicationConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public ServerServiceDefinition userService() {
        return AvroGrpcServer.createServiceDefinition(UserService.class, userService);
    }
}
