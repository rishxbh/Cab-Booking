package com.rishabh.carbooking.repository;

import com.rishabh.carbooking.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookingRepository {
    List<Booking> bookingList = new ArrayList<>();
    public Booking save(Booking booking) {
        bookingList.add(booking);
        return bookingList.get(bookingList.size() - 1);
    }
}
