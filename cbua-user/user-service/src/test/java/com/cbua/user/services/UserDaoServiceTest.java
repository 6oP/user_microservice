package com.cbua.user.services;


import com.cbua.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserDaoServiceTest {

    @Autowired
    private UserDaoService userDaoService;

    @Test
    public void createUserTest() {
        userDaoService.create("Foo", "Bar", "test@test.com", "passwd");
    }

    @Test
    public void addAddressToUser() {
        User user = userDaoService.create("Foo", "Bar", "test2@test.com", "passwd");
        userDaoService.addAddress(user.getId(), UUID.randomUUID());
        Assertions.assertFalse(userDaoService.getUserAddresses(user.getId()).isEmpty());
    }
}
