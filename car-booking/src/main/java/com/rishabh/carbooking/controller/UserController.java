package com.rishabh.carbooking.controller;

import com.rishabh.carbooking.dto.requests.UserRequest;
import com.rishabh.carbooking.model.User;
import com.rishabh.carbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add_user")
    public User addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.getAllUser();
    }

}
