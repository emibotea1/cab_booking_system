package com.emanuel.cab.controller;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.User;
import com.emanuel.cab.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
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
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByUsername(userDto.getEmail());

        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "There is already an account registered with the same username");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String getViewOfUsers(Model model) {
        List<UserDto> userDtos = userService.findAllUsers();
        model.addAttribute("users", userDtos);

        return "users";
    }
}
