package com.cbua.user.services;

import com.cbua.user.avro.UserDetails;
import com.cbua.user.avro.UserService;
import com.cbua.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class GrpcUserServiceTest {
    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserService userService;

    @Test
    public void getUsers() {

        User user = userDaoService.create("Foo", "Bar", "getusers@test.com", "passwd");
        List<UserDetails> users = userService.getUsers(Collections.singletonList(user.getId().toString()));
        Assertions.assertFalse(users.isEmpty());
    }
}
