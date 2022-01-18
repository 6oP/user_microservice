package com.cbua.address.services;

import com.cbua.address.domain.Address;
import com.cbua.address.domain.User;

import java.util.List;
import java.util.UUID;

public interface AddressDaoService {

    User addUser(UUID addressId, UUID userId);

    Address create(String addressOne, String addressTwo, String city, Integer zip, String country);

    List<UUID> findUsersFromCountry(String country);
}
