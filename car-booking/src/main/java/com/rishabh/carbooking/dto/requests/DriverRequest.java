package com.rishabh.carbooking.dto.requests;

import com.rishabh.carbooking.dto.transferObjects.Coordinates;
import com.rishabh.carbooking.model.DriverDetails;
import lombok.Data;

@Data
public class DriverRequest {
    private DriverDetails driverDetails;
    private String carModel;
    private String registrationNumber;
    private Coordinates coordinates;
}
