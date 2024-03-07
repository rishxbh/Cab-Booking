package com.rishabh.carbooking.controller;

import com.rishabh.carbooking.dto.requests.DriverRequest;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;
import com.rishabh.carbooking.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add_driver")
    public Driver addDriver(@RequestBody DriverRequest driverRequest) {
        return driverService.addDriver(driverRequest);
    }

    @GetMapping("/all_drivers")
    public List<Driver> allDrivers() {
        return driverService.allDrivers();
    }

    @PutMapping("/change_status")
    public Driver changeStatus(@RequestBody DriverDetails driverDetails) {
        return driverService.changeStatus(driverDetails);
    }

}
