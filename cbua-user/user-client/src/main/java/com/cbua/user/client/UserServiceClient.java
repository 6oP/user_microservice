package com.cbua.user.client;


import com.cbua.user.avro.CreateUser;
import com.cbua.user.avro.UserDetails;
import com.cbua.user.avro.UserService;
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
public class UserServiceClient implements Closeable {

    private static final Logger log = LoggerFactory.getLogger(UserServiceClient.class);

    private final ManagedChannel channel;
    private final UserService stub;

    public UserServiceClient(UserServiceClientConfig config) {
        this.channel = ManagedChannelBuilder.forAddress(config.getHost(), config.getPort()).usePlaintext().build();
        this.stub = AvroGrpcClient.create(channel, UserService.class);
    }

    public String createUser(String firstName, String lastName, String email, String password) {
        CreateUser message = CreateUser.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password) // TODO hash it on client side ?
                .build();
        return stub.createUser(message);
    }

    public void addAddressToUser(UUID userId, UUID addressId) {
        stub.addAddressToUser(userId.toString(), addressId.toString());
    }

    public List<UserDetails> getUsers(List<UUID> userIds) {
        return stub.getUsers(userIds.stream().map(UUID::toString).collect(Collectors.toList()));
    }

    public UserDetails getUser(UUID userId) {
        return stub.getUser(userId.toString());
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
