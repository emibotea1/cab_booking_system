package com.emanuel.cab.service;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.model.Booking;
import com.emanuel.cab.model.Driver;
import com.emanuel.cab.repository.BookingRepository;
import com.emanuel.cab.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final IUserService userService;
    private final DriverRepository driverRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, IUserService userService,
                              DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.driverRepository = driverRepository;
    }

    @Override
    public Booking saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();

        booking.setPickUpLocation(bookingDto.getPickUpLocation());
        booking.setDropOffPoint(bookingDto.getDropOffPoint());
        booking.setCreatedAt(System.currentTimeMillis());
        booking.setUsers(userService.getCurrentlyAuthenticatedUser());
        booking.setDrivers(bookingDto.getDriverId());

        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public List<Driver> findAllAvailableDrivers() {
        return driverRepository.findAllDriversByAvailability();
    }


    @Override
    public List<BookingDto> findAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private BookingDto convertEntityToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setPickUpLocation(booking.getPickUpLocation());
        bookingDto.setDropOffPoint(booking.getDropOffPoint());
        bookingDto.setCreatedAt(booking.getCreatedAt());
        bookingDto.setDriverName(booking.getDrivers().getName());
        bookingDto.setDriverPhoneNumber(booking.getDrivers().getPhoneNumber());
        return bookingDto;
    }
}
