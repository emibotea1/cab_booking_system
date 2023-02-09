package com.emanuel.cab.controller;

import com.emanuel.cab.dto.DriverDto;
import com.emanuel.cab.service.IDriverService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DriverController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

    private final IDriverService iDriverService;

    public DriverController(IDriverService iDriverService) {
        this.iDriverService = iDriverService;
    }

    @GetMapping("driver")
    public ModelAndView showDriverRegistrationPage(Model model) throws Exception {
        DriverDto driverDto = new DriverDto();
        model.addAttribute("driver", driverDto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("driver", driverDto);

        return modelAndView;
    }

    @PostMapping("driver/save")
    public ModelAndView registerNewDriver(@ModelAttribute("driver") @Valid DriverDto driverDto) {
        String target = "redirect: " + "/driver";

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(target);

        iDriverService.saveDriver(driverDto);
        LOGGER.info("The registration for the user with username: {} was successful!", driverDto.getName());

        return modelAndView;
    }
}
