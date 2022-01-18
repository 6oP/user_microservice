package com.cbua.address.services;

import com.cbua.address.domain.Address;
import com.cbua.address.domain.User;
import com.cbua.address.repository.AddressRepository;
import com.cbua.address.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AddressDaoServiceImpl implements AddressDaoService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public AddressDaoServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(String addressOne, String addressTwo, String city, Integer zip, String country) {
        var address = new Address(addressOne, addressTwo, city, zip, country);
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public User addUser(UUID addressId, UUID userId) {
        Address address = addressRepository.getById(addressId);
        var user = new User(address, userId);
        userRepository.save(user);
        address.getUsers().add(user);
        return user;
    }

    @Override
    public List<UUID> findUsersFromCountry(String country) {
        return userRepository.findUsersFromCountry(country);
    }
}
