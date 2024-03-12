package com.rishabh.carbooking.dto.requests;

import com.rishabh.carbooking.dto.transferObjects.Gender;
import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String name;
    private Gender gender;
    private int age;

}
