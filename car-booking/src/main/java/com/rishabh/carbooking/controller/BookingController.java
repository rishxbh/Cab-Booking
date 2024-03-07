package com.rishabh.carbooking.controller;

import com.rishabh.carbooking.dto.requests.BookingConfirmation;
import com.rishabh.carbooking.dto.requests.BookingRequest;
import com.rishabh.carbooking.dto.requests.UserRequest;
import com.rishabh.carbooking.dto.responses.DriverResponse;
import com.rishabh.carbooking.model.Booking;
import com.rishabh.carbooking.model.Driver;
import com.rishabh.carbooking.model.User;
import com.rishabh.carbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

        @Autowired
        private BookingService bookingService;

        @GetMapping("/find_ride")
        public List<DriverResponse> findNearbyRides(@RequestBody BookingRequest bookingRequest) {
            return bookingService.getNearbyDrivers(bookingRequest);
        }

        @PostMapping("/choose_ride")
        public Booking confirmBooking(@RequestBody BookingConfirmation bookingConfirmation) {
            return bookingService.confirmRide(bookingConfirmation);
        }

}
