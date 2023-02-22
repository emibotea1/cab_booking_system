package com.emanuel.cab.controller;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.service.BookingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class BookedCabsController {

    private final BookingServiceImpl bookingService;

    public BookedCabsController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booked_cabs")
    public String listOfBookings(Model model) {
        List<BookingDto> listOfBookings = bookingService.findAllBooking();
        model.addAttribute("listOfBookings", listOfBookings);

        return "booked_cabs";
    }
}
