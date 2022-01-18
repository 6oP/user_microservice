package com.cbua.user.services;

import com.cbua.user.avro.CreateUser;
import com.cbua.user.avro.UserDetails;
import com.cbua.user.avro.UserService;
import com.cbua.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GrpcUserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(GrpcUserServiceImpl.class);
    private final UserDaoService userDaoService;

    public GrpcUserServiceImpl(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @Override
    public String createUser(CreateUser createUserRequest) {
        User user = userDaoService.create(createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword());
        return user.getId().toString();
    }

    @Override
    public UserDetails getUser(String userId) {
        User user = userDaoService.getUser(UUID.fromString(userId));
        return toUserDetail(user);
    }

    @Override
    public void addAddressToUser(String userId, String addressId) {
        userDaoService.addAddress(UUID.fromString(userId), UUID.fromString(addressId));
    }

    @Override
    @Transactional
    public List<UserDetails> getUsers(List<String> userIds) {
        return userIds.stream().map(this::getUser).collect(Collectors.toList());
    }

    private UserDetails toUserDetail(User user) {
        return UserDetails.newBuilder().setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail()).build();
    }
}
