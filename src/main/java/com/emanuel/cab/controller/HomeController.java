package com.emanuel.cab.controller;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.service.IUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    private final IUserService IUserService;

    public HomeController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/users")
    public String getViewOfUsers(Model model) {
        List<UserDto> userDtos = IUserService.findAllUsers();
        model.addAttribute("users", userDtos);

        return "users";
    }
}
