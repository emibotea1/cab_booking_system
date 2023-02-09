package com.emanuel.cab.controller;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;
import com.emanuel.cab.repository.RoleRepository;
import com.emanuel.cab.service.IUserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthenticatingController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticatingController.class);
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
    public ModelAndView showRegistrationForm(Model model) throws Exception {
        UserDto userDto = new UserDto();
        model.addAttribute("userr", userDto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("register", userDto);

        return modelAndView;
    }

    //TODO: make a success message!
    //TODO: MAKE SURE THAT THE EMAIL IS UNIQUE
    @PostMapping("/register/save")
    public ModelAndView registration(@ModelAttribute("userr") @Valid UserDto userDto,
                                     BindingResult result) {
        Userr existingUserr = IUserService.findUserByUsername(userDto.getUsername());

        if (existingUserr != null) {
            LOGGER.error("There is already an account registered with the username : {}", userDto.getUsername());
            result.rejectValue("username", "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            String target = "redirect: " + "/register";
            modelAndView.setViewName(target);

            return modelAndView;
        }

        String target = "redirect: " + "/register";

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(target);

        IUserService.saveUser(userDto);
        LOGGER.info("The registration for the user with username: {} was successful!", userDto.getUsername());
        return modelAndView;
    }
}
