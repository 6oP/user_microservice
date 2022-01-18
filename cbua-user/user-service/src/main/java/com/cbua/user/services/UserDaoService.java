package com.cbua.user.services;

import com.cbua.user.domain.Address;
import com.cbua.user.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserDaoService {

    List<Address> getUserAddresses(UUID userId);

    Address addAddress(UUID userId, UUID addressId);

    User create(String firstName, String lastName, String email, String password);

    User getUser(UUID userId);
}
