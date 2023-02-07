package com.emanuel.cab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BookedCabsController {

    @GetMapping("/booked_cabs")
    public ModelAndView getViewOfBookedCabs() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("booked_cabs");

        return modelAndView;
    }
}
