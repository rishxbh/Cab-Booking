package com.rishabh.carbooking.model;

import com.rishabh.carbooking.dto.transferObjects.Gender;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DriverDetails {
    private String name;
    private Gender gender;
    private int age;
}
