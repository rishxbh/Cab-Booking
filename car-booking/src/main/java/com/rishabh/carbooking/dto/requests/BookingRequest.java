package com.rishabh.carbooking.dto.requests;

import com.rishabh.carbooking.dto.transferObjects.Coordinates;
import lombok.Data;

@Data
public class BookingRequest {
    private String userName;
    private Coordinates startPoint;
    private Coordinates endPoint;
}
