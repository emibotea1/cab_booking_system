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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class BookingController {

    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public ModelAndView booking() {
        ModelAndView modelAndView = new ModelAndView();
        BookingDto bookingDto = new BookingDto();
        modelAndView.addObject("booking", bookingDto);

        return modelAndView;
    }

    @PostMapping("/booking/save")
    public ModelAndView bookACab(
            @Valid BookingDto bookingDto,
            BindingResult result,
            final RedirectAttributes redirectAttributes
    ) {
        ModelAndView modelAndView = new ModelAndView();

        String target = "redirect:" + "/booking";
//        redirectAttributes.addFlashAttribute("error", true);
//        redirectAttributes.addFlashAttribute("added", "Error message here");
        //redirectAttributes.addFlashAttribute("alert alert-info", true);
        redirectAttributes.addFlashAttribute( "success","You've successfully booked a cab. Enjoy your ride!");
        modelAndView.setViewName(target);

        bookingService.saveBooking(bookingDto);

        return modelAndView;
    }
}
