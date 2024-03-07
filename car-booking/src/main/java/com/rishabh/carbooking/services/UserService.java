package com.rishabh.carbooking.services;

import com.rishabh.carbooking.dto.requests.UserRequest;
import com.rishabh.carbooking.model.User;

import java.util.List;

public interface UserService {
    User addUser(UserRequest userRequest);
    List<User> getAllUser();
}
