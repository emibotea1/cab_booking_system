package com.emanuel.cab.service;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;
import com.emanuel.cab.model.Role;
import com.emanuel.cab.repository.RoleRepository;
import com.emanuel.cab.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Userr saveUser(UserDto userDto) {

        Userr userr = new Userr();
        userr.setFirstName(userDto.getFirstName());
        userr.setLastName(userDto.getLastName());
        userr.setEmail(userDto.getEmail());
        userr.setPhoneNumber(userDto.getPhoneNumber());
        userr.setUsername(userDto.getUsername());
        userr.setPassword(passwordEncoder.encode(userDto.getPassword()));

       Role role = roleRepository.findRoleByName("ROLE_USER");
       userr.setRoles(List.of(role));

        userRepository.save(userr);
        return userr;
    }

    @Override
    public Userr findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<Userr> userrs = userRepository.findAll();

        return userrs.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Userr getCurrentlyAuthenticatedUser() {
            var principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            var username = principal.getUsername();
            return findUserByUsername(username);
    }

    private UserDto convertEntityToDto(Userr userr) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(userr.getFirstName());
        userDto.setLastName(userr.getLastName());
        userDto.setEmail(userr.getEmail());
        userDto.setPhoneNumber(userr.getPhoneNumber());
        userDto.setUsername(userr.getUsername());
        userDto.setPassword(userr.getPassword());

        return userDto;
    }
}
