package com.cbua.address.services;


import com.cbua.address.domain.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class AddressDaoServiceTest {

    @Autowired
    private AddressDaoService addressDaoService;

    @Test
    public void addUserToAddress() {
        Address address = addressDaoService.create("1", "2", "Odeassa", 6500, "Ukraine");
        addressDaoService.addUser(address.getId(), UUID.randomUUID());
    }

    @Test
    void findUsersFromCountry() {

        Address address1 = addressDaoService.create("1", "2", "Odeassa", 6500, "Ukraine");
        Address address2 = addressDaoService.create("1", "2", "Odeassa", 6500, "US");
        addressDaoService.addUser(address1.getId(), UUID.randomUUID());
        UUID user2Id = UUID.randomUUID();
        addressDaoService.addUser(address2.getId(), user2Id);

        List<UUID> userIds = addressDaoService.findUsersFromCountry("US");
        Assertions.assertFalse(userIds.isEmpty());
        Assertions.assertEquals(1, userIds.size());
        Assertions.assertEquals(user2Id, userIds.get(0));
    }
}
