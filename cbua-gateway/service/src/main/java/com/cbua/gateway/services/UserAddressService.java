package com.cbua.gateway.services;

import com.cbua.address.client.AddressServiceClient;
import com.cbua.gateway.controllers.CreateUserDto;
import com.cbua.gateway.controllers.UserDto;
import com.cbua.user.client.UserServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserAddressService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceClient.class);

    private final UserServiceClient userServiceClient;

    public final AddressServiceClient addressServiceClient;

    public UserAddressService(UserServiceClient userServiceClient, AddressServiceClient addressServiceClient) {
        this.userServiceClient = userServiceClient;
        this.addressServiceClient = addressServiceClient;
    }

    public UUID createUserWithAddress(CreateUserDto userDto) {
        // TODO in case of failure execute compensation request to clean the state

        // create User
        log.info("Calling user service to create the user '{}'", userDto.getEmail());
        var userIdString = userServiceClient.createUser(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword());
        var userId = UUID.fromString(userIdString);
        log.info("User has been create with id '{}'", userId);

        // create address
        var address = userDto.getAddress();
        log.info("Calling address service to create the address '{}'", address);
        String addressIdString = addressServiceClient.createAddress(address.getAddressOne(),
                address.getAddressTwo(),
                address.getCity(),
                address.getZip(),
                address.getCountry());

        var addressId = UUID.fromString(addressIdString);

        log.info("Calling address service to link user:'{}' with address: '{}'", userDto.getEmail(), address);
        addressServiceClient.addUserToAddress(addressId, userId);

        log.info("Calling user service to link user:'{}' with address: '{}'", userDto.getEmail(), address);
        userServiceClient.addAddressToUser(userId, addressId);

        return userId;
    }

    public List<UserDto> findUsersByCountry(String country) {
        List<UUID> userIds = addressServiceClient.getUserIdsByCountry(country);
        log.info("Users '{}' were found by country '{}'", userIds, country);
        return userServiceClient.getUsers(userIds).stream().map(userDetails -> {
            var user = new UserDto();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            return user;
        }).collect(Collectors.toList());
    }
}
