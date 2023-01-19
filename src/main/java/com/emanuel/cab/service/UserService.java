package com.emanuel.cab.service;


import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByUsername(String username);

    List<UserDto> findAllUsers();
}
