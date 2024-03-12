package com.rishabh.carbooking.services.impl;

import com.rishabh.carbooking.converters.DriverConverter;
import com.rishabh.carbooking.dto.requests.BookingConfirmation;
import com.rishabh.carbooking.dto.requests.BookingRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.exceptions.RiderNotFoundException;
import com.rishabh.carbooking.exceptions.UserNotFoundException;
import com.rishabh.carbooking.model.Booking;
import com.rishabh.carbooking.dto.transferObjects.Coordinates;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;
import com.rishabh.carbooking.model.User;
import com.rishabh.carbooking.repository.BookingRepository;
import com.rishabh.carbooking.repository.DriverRepository;
import com.rishabh.carbooking.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

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
    public Booking confirmRide(BookingConfirmation bookingConfirmation) throws RiderNotFoundException, UserNotFoundException {
        BookingRequest request = bookingConfirmation.getBookingRequest();
        DriverDetails driverDetails = bookingConfirmation.getDriverDetails();
        validateDriver(driverDetails);
        validateUser(request.getUserName());
        Booking booking = Booking.builder().
            driverDetails(driverDetails).
                startPoint(request.getStartPoint()).
                endPoint(request.getEndPoint()).
                userName(request.getUserName()).
                build();
        driverRepository.changeStatus(driverDetails, request.getEndPoint());
        return bookingRepository.save(booking);
    }

    private void validateDriver(DriverDetails driverDetails) throws RiderNotFoundException {
        if(!driverRepository.driverDetailsToDriver(driverDetails)) {
            throw new RiderNotFoundException("Driver Details does not matched");
        }
    }

    private void validateUser(String userName) throws UserNotFoundException {
        if(!userRepository.checkIfExist(userName)) {
            throw new UserNotFoundException("UserName doesn't found");
        }
    }
}
