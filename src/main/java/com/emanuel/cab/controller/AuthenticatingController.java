package com.emanuel.cab.controller;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;
import com.emanuel.cab.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthenticatingController {

    private final IUserService IUserService;

    public AuthenticatingController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("userr") @Valid UserDto userDto,
                               BindingResult result,
                               Model model) {
        Userr existingUserr = IUserService.findUserByUsername(userDto.getUsername());

        if (existingUserr != null) {
            result.rejectValue("username", "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            model.addAttribute("userr", userDto);
            return "/register";
        }

        IUserService.saveUser(userDto);
        return "redirect:/register?success";
    }
}
