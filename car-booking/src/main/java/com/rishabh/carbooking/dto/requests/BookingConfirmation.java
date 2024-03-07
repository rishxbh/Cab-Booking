package com.rishabh.carbooking.dto.requests;

import com.rishabh.carbooking.model.DriverDetails;
import lombok.Data;

@Data
public class BookingConfirmation {
    private BookingRequest bookingRequest;
    private DriverDetails driverDetails;
}
