package com.emanuel.cab.service;


import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Userr;

import java.util.List;

public interface IUserService {

    /**
     * <p>This is a simple description of the method. . .
     *  <a href="http://www.supermanisthegreatest.com">Superman!</a>
     *  </p>
     * @param userDto simple DTO class
     * @return Userr - bla bla
     * Ce am facut:
     * - redenumirea clasei
     */
    Userr saveUser(UserDto userDto);

    Userr findUserByUsername(String username);

    List<UserDto> findAllUsers();

    Userr getCurrentlyAuthenticatedUser();
}
