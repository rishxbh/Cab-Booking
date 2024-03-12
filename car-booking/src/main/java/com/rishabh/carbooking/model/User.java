package com.rishabh.carbooking.model;

import com.rishabh.carbooking.dto.transferObjects.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private Gender gender;
    private int age;
}
