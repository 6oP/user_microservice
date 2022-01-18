package com.cbua.address.services;

import com.cbua.address.avro.AddressService;
import com.cbua.address.avro.CreateAddress;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GrpcAddressServiceImpl implements AddressService {
    private final AddressDaoService addressDaoService;

    public GrpcAddressServiceImpl(AddressDaoService addressDaoService) {
        this.addressDaoService = addressDaoService;
    }

    @Override
    public String createAddress(CreateAddress address) {
        return addressDaoService.create(address.getAddressOne(),
                address.getAddressTwo(),
                address.getCity(),
                address.getZip(),
                address.getCountry()).getId().toString();
    }

    @Override
    public void addUserToAddress(String addressId, String userId) {
        addressDaoService.addUser(UUID.fromString(addressId), UUID.fromString(userId));
    }

    @Override
    public List<String> getUserIdsByCountry(String country) {
        List<UUID> usersFromCountry = addressDaoService.findUsersFromCountry(country);
        return usersFromCountry.stream().map(UUID::toString).collect(Collectors.toList());
    }
}
