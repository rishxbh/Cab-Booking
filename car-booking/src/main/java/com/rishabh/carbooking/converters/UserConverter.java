package com.rishabh.carbooking.converters;

import com.rishabh.carbooking.dto.requests.UserRequest;
import com.rishabh.carbooking.model.User;

public class UserConverter {

    public static User convertDtoToModel(UserRequest userRequest) {
        User user = User.builder().age(userRequest.getAge()).gender(userRequest.getGender()).name(userRequest.getName())
                .build();
        return user;
    }

}
