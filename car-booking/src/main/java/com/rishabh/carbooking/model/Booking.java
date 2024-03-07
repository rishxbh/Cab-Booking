package com.rishabh.carbooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {
    private String userName;
    private DriverDetails driverDetails;
    private Coordinates startPoint;
    private Coordinates endPoint;
}
