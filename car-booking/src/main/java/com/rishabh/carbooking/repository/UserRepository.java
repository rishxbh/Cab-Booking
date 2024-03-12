package com.rishabh.carbooking.repository;

import com.rishabh.carbooking.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    HashMap<String, User> userList = new HashMap<>();
    public User save(String userName, User user) {
        userList.put(userName, user);
        return userList.get(userName);
    }
    public List<User> findAll() {
        return new ArrayList<>(userList.values());
    }
    public boolean checkIfExist(String userName) {
        return userList.containsKey(userName);
    }
}
