package com.rishabh.carbooking.services.impl;

import com.rishabh.carbooking.converters.UserConverter;
import com.rishabh.carbooking.dto.requests.UserRequest;
import com.rishabh.carbooking.model.User;
import com.rishabh.carbooking.repository.UserRepository;
import com.rishabh.carbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(UserRequest userRequest) {
        User user = UserConverter.convertDtoToModel(userRequest);
        return repository.save(userRequest.getUserName(), user);
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }
}
