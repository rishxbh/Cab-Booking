package com.rishabh.carbooking.model;

import com.rishabh.carbooking.dto.transferObjects.Coordinates;
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
