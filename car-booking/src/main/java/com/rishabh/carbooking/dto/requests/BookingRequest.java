package com.rishabh.carbooking.dto.requests;

import com.rishabh.carbooking.model.Coordinates;
import lombok.Data;

@Data
public class BookingRequest {
    private String userName;
    private Coordinates startPoint;
    private Coordinates endPoint;
}
