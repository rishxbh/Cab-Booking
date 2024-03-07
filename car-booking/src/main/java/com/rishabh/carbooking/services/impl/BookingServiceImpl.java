package com.rishabh.carbooking.services.impl;

import com.rishabh.carbooking.converters.DriverConverter;
import com.rishabh.carbooking.dto.requests.BookingConfirmation;
import com.rishabh.carbooking.dto.requests.BookingRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.model.Booking;
import com.rishabh.carbooking.model.Coordinates;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;
import com.rishabh.carbooking.repository.BookingRepository;
import com.rishabh.carbooking.repository.DriverRepository;
import com.rishabh.carbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverResponse> getNearbyDrivers(BookingRequest bookingRequest) {
        Coordinates userLocation = bookingRequest.getStartPoint();
        List<Driver> nearByDrivers = driverRepository.findByCoordinates(userLocation);
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver : nearByDrivers) {
            int driverX = driver.getCoordinates().getX();
            int driverY = driver.getCoordinates().getY();
            int farFromClient = Math.abs(driverX - userLocation.getX()) + Math.abs(driverY - userLocation.getY());
            driverResponses.add(DriverConverter.convertModelToDto(driver, farFromClient));
        }
        return driverResponses;
    }
    public Booking confirmRide(BookingConfirmation bookingConfirmation) {
        BookingRequest request = bookingConfirmation.getBookingRequest();
        DriverDetails driverDetails = bookingConfirmation.getDriverDetails();
        Booking booking = Booking.builder().
            driverDetails(driverDetails).
                startPoint(request.getStartPoint()).
                endPoint(request.getEndPoint()).
                userName(request.getUserName()).
                build();
        driverRepository.changeStatus(driverDetails, request.getEndPoint());
        return bookingRepository.save(booking);
    }
}
