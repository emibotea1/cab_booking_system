package com.emanuel.cab.controller;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;
import com.emanuel.cab.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final IUserService IUserService;

    public HomeController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model) throws Exception {
        UserDto userDto = new UserDto();
        model.addAttribute("userr", userDto);

        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("userr") @Valid UserDto userDto,
                               BindingResult result,
                               Model model, HttpServletRequest request,
                               Errors errors) {
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

    @GetMapping("/users")
    public String getViewOfUsers(Model model) {
        List<UserDto> userDtos = IUserService.findAllUsers();
        model.addAttribute("users", userDtos);

        return "users";
    }
}
