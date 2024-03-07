package com.rishabh.carbooking.dto.responses;

import com.rishabh.carbooking.model.DriverDetails;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverResponse {
    private DriverDetails driverDetails;
    private int farFromYourLocation;
}
