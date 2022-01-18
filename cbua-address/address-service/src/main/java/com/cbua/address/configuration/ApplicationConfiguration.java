package com.cbua.address.configuration;

import com.cbua.address.avro.AddressService;
import io.grpc.ServerServiceDefinition;
import org.apache.avro.grpc.AvroGrpcServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    private final AddressService addressService;

    public ApplicationConfiguration(AddressService addressService) {
        this.addressService = addressService;
    }

    @Bean
    public ServerServiceDefinition userService() {
        return AvroGrpcServer.createServiceDefinition(AddressService.class, addressService);
    }
}
