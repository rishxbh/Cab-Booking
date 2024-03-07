package com.rishabh.carbooking.converters;

import com.rishabh.carbooking.dto.requests.DriverRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.model.Driver;

public class DriverConverter {
    public static Driver convertDtoToModel(DriverRequest driverRequest) {
        Driver driver = Driver.builder().
                driverDetails(driverRequest.getDriverDetails()).
                carModel(driverRequest.getCarModel()).
                registrationNumber(driverRequest.getRegistrationNumber()).
                coordinates(driverRequest.getCoordinates()).
                available(true).
                build();
        return driver;
    }
    public static DriverResponse convertModelToDto(Driver driver, int units) {
        DriverResponse driverResponse = DriverResponse.builder().
                driverDetails(driver.getDriverDetails()).
                farFromYourLocation(units).build();
        return driverResponse;
    }
}
