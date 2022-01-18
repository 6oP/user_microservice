package com.cbua.user.services;

import com.cbua.user.domain.Address;
import com.cbua.user.domain.User;
import com.cbua.user.repository.AddressRepository;
import com.cbua.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class UserDaoServiceImp implements UserDaoService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserDaoServiceImp(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User create(String firstName, String lastName, String email, String password) {
        var user = new User(firstName, lastName, email, password);
        return userRepository.save(user);
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.getById(userId);
    }

    @Transactional
    @Override
    public List<Address> getUserAddresses(UUID userId) {
        List<Address> addresses = getUser(userId).getAddresses();
        addresses.size();
        return addresses;
    }


    @Override
    @Transactional
    public Address addAddress(UUID userId, UUID addressId) {
        User user = userRepository.getById(userId);
        Address address = new Address(user, addressId);
        addressRepository.save(address);
        user.getAddresses().add(address);
        userRepository.save(user);
        return address;
    }
}
