package com.rishabh.carbooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Driver {
    private DriverDetails driverDetails;
    private String carModel;
    private String registrationNumber;
    private Coordinates coordinates;
    private boolean available;
}
