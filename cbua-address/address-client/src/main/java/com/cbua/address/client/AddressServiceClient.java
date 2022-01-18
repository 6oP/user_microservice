package com.cbua.address.client;

import com.cbua.address.avro.AddressService;
import com.cbua.address.avro.CreateAddress;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.avro.grpc.AvroGrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AddressServiceClient implements Closeable {

    private static final Logger log = LoggerFactory.getLogger(AddressServiceClient.class);

    private final ManagedChannel channel;
    private final AddressService stub;

    public AddressServiceClient(AddressServiceClientConfig config) {
        this.channel = ManagedChannelBuilder.forAddress(config.getHost(), config.getPort()).usePlaintext().build();
        this.stub = AvroGrpcClient.create(channel, AddressService.class);
    }

    public String createAddress(String addressOne, String addressTwo, String city, Integer zip, String country) {
        CreateAddress address = CreateAddress.newBuilder()
                .setAddressOne(addressOne)
                .setAddressTwo(addressTwo)
                .setCity(city)
                .setZip(zip)
                .setCountry(country)
                .build();
        log.info("Sending address to the address service");
        return stub.createAddress(address);
    }

    public void addUserToAddress(UUID addressId, UUID userId) {
        stub.addUserToAddress(addressId.toString(), userId.toString());
    }

    public List<UUID> getUserIdsByCountry(String country) {
        return stub.getUserIdsByCountry(country).stream().map(UUID::fromString).collect(Collectors.toList());
    }

    @Override
    public void close() {
        shutdown();
    }

    public void shutdown() {
        log.info("Shutting down user service client");
        channel.shutdown();
    }
}
