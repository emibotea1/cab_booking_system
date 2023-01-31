package com.emanuel.cab.service;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.model.Booking;

import java.util.List;

public interface IBookingService {
    List<BookingDto> findAllBooking();

    Booking saveBooking(BookingDto bookingDto);
}
