package com.rishabh.carbooking.services;

import com.rishabh.carbooking.dto.requests.BookingConfirmation;
import com.rishabh.carbooking.dto.requests.BookingRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.exceptions.RiderNotFoundException;
import com.rishabh.carbooking.exceptions.UserNotFoundException;
import com.rishabh.carbooking.model.Booking;

import java.util.List;

public interface BookingService {
    List<DriverResponse> getNearbyDrivers(BookingRequest bookingRequest);
    public Booking confirmRide(BookingConfirmation bookingConfirmation) throws RiderNotFoundException, UserNotFoundException;
}
