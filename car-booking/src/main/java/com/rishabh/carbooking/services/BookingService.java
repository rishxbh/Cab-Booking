package com.rishabh.carbooking.services;

import com.rishabh.carbooking.dto.requests.BookingConfirmation;
import com.rishabh.carbooking.dto.requests.BookingRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.model.Booking;
import com.rishabh.carbooking.model.Coordinates;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.DriverDetails;

import java.util.List;

public interface BookingService {
    List<DriverResponse> getNearbyDrivers(BookingRequest bookingRequest);
    public Booking confirmRide(BookingConfirmation bookingConfirmation);
}
