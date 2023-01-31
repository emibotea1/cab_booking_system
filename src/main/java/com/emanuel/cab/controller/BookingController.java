package com.emanuel.cab.controller;

import com.emanuel.cab.dto.BookingDto;
import com.emanuel.cab.service.IBookingService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public String booking(Model model) {
        BookingDto bookingDto = new BookingDto();
        model.addAttribute("booking", bookingDto);

        return "booking";
    }

    @PostMapping("/booking/save")
    public String bookACab(@ModelAttribute("booking")
                           @Valid BookingDto bookingDto,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            model.addAttribute("booking", bookingDto);
            return "/booking";
        }

        bookingService.saveBooking(bookingDto);
        return "redirect:/booking?success";
    }
}
