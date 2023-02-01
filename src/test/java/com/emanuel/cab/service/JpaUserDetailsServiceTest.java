package com.emanuel.cab.service;

import com.emanuel.cab.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.when;

class JpaUserDetailsServiceTest {

    @Mock // de citit despre mocking
    UserRepository userRepository;

    JpaUserDetailsService underTest;

    @Test
    void loadUserByUsernameShouldThrowExceptionWhenUsernameIsNotFound() {
    }

//    @Test
//    void loadUserByUsernameShouldWorkProperlyWhenUsernameExists() {
//        //given
//        String username = "Lucian27";
//        User expectedResult = new User("Lucian27", "dummyPassword", );
//
//        //when
//        when(userRepository.findByEmail()).thenReturn();
//
//        //then
//        UserDetails actualResult = underTest.loadUserByUsername(username);
//
//    }
}