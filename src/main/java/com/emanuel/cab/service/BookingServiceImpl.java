package com.emanuel.cab.service;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.model.Booking;
import com.emanuel.cab.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setPickUpLocation(bookingDto.getPickUpLocation());
        booking.setDropOffPoint(bookingDto.getDropOffPoint());
        booking.setCreatedAt(System.currentTimeMillis());

        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public List<BookingDto> findAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private BookingDto convertEntityToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setPickUpLocation(bookingDto.getPickUpLocation());
        bookingDto.setDropOffPoint(booking.getDropOffPoint());
        bookingDto.setCreatedAt(booking.getCreatedAt());
        return bookingDto;
    }
}
