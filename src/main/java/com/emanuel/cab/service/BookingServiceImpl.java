package com.emanuel.cab.service;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.model.Booking;
import com.emanuel.cab.repository.BookingRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final IUserService userService;

    public BookingServiceImpl(BookingRepository bookingRepository, IUserService userService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
    }

    /*
    booking.setUsers() -> vreau sa imi seteze id-ul corespunzator user-ului care s-a conectat la aplicatie
     */
    @Override
    public Booking saveBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        //Userr userr = new Userr();
        booking.setPickUpLocation(bookingDto.getPickUpLocation());
        booking.setDropOffPoint(bookingDto.getDropOffPoint());
        booking.setCreatedAt(System.currentTimeMillis());
        int userId = findIdOfAuthenticatedUser();


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

    private int findIdOfAuthenticatedUser() {
        var principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username = principal.getUsername();
        var myLoggedInUser = userService.findUserByUsername(username);

        return myLoggedInUser.getId();
    }
}
