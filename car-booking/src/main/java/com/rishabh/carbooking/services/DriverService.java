package com.rishabh.carbooking.services;

import com.rishabh.carbooking.dto.requests.DriverRequest;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;

import java.util.List;

public interface DriverService {
    Driver addDriver(DriverRequest driverRequest);
    List<Driver> allDrivers();

    Driver changeStatus(DriverDetails driverDetails);
}
