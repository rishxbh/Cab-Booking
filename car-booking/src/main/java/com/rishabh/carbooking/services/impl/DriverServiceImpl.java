package com.rishabh.carbooking.services.impl;

import com.rishabh.carbooking.converters.DriverConverter;
import com.rishabh.carbooking.dto.requests.DriverRequest;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;
import com.rishabh.carbooking.repository.DriverRepository;
import com.rishabh.carbooking.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver addDriver(DriverRequest driverRequest) {
        Driver driver = DriverConverter.convertDtoToModel(driverRequest);
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> allDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver changeStatus(DriverDetails driverDetails) {
        return driverRepository.changeStatus(driverDetails);
    }

}
