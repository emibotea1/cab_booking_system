package com.emanuel.cab.service;


import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;

import java.util.List;

public interface UserService {

    Userr saveUser(UserDto userDto);

    Userr findUserByUsername(String username);

    List<UserDto> findAllUsers();
}
