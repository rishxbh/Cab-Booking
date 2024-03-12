package com.rishabh.carbooking.repository;

import com.rishabh.carbooking.dto.transferObjects.Coordinates;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DriverRepository {
    List<Driver> driverList = new ArrayList<>();
    public Driver save(Driver driver) {
        driverList.add(driver);
        return driverList.get(driverList.size() - 1);
    }
    public List<Driver> findAll() {
        return driverList;
    }

    // query to find drivers under 5 unit of distance
    public List<Driver> findByCoordinates(Coordinates userLocation) {
        int userX = userLocation.getX();
        int userY = userLocation.getY();
        List<Driver> list = driverList.stream().filter(driver ->
            Math.abs(driver.getCoordinates().getX() - userX)
                    + Math.abs(driver.getCoordinates().getY() - userY) <= 5 && driver.isAvailable()
        ).collect(Collectors.toList());
        return list;
    }
    //in case of booking done
    public Driver changeStatus(DriverDetails driverDetails, Coordinates endPoint) {
        for(int i = 0; i < driverList.size(); i++) {
            if(driverList.get(i).getDriverDetails().toString().equals(driverDetails.toString())) {
                Driver driver = driverList.get(i);
                driver.setAvailable(false);
                driver.setCoordinates(endPoint);
                driverList.set(i, driver);
                return driverList.get(i);
            }
        }
        return null;
    }
    //in case of changing status
    public Driver changeStatus(DriverDetails driverDetails) {
        for(int i = 0; i < driverList.size(); i++) {
            if(driverList.get(i).getDriverDetails().toString().equals(driverDetails.toString())) {
                Driver driver = driverList.get(i);
                if(driver.isAvailable()) {
                    driver.setAvailable(false);
                } else {
                    driver.setAvailable(true);
                }
                driverList.set(i, driver);
                return driverList.get(i);
            }
        }
        return null;
    }

    public boolean driverDetailsToDriver(DriverDetails driverDetails) {
        for(Driver driver : driverList) {
            if(driver.getDriverDetails().toString().equals(driverDetails.toString())) return true;
        }
        return false;
    }
}
