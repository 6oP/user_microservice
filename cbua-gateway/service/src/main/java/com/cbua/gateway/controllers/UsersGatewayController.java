package com.cbua.gateway.controllers;

import com.cbua.gateway.services.UserAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UsersGatewayController {

    private final UserAddressService userAddressService;

    public UsersGatewayController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @PostMapping("/users")
    public UUID createUser(@RequestBody CreateUserDto request) {
        return userAddressService.createUserWithAddress(request);
    }

    @GetMapping("/users")
    public List<UserDto> findUsersByCountry(@RequestParam String country) {
        return userAddressService.findUsersByCountry(country);
    }
}
