package com.emanuel.cab.service;

import com.emanuel.cab.dto.UserDto;
import com.emanuel.cab.model.Role;
import com.emanuel.cab.model.Userr;
import com.emanuel.cab.repository.RoleRepository;
import com.emanuel.cab.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.function.BooleanSupplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplementationTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private RoleRepository roleRepository;
    private UserServiceImplementation underTest;

    @BeforeAll
    void setUp() {
        underTest = new UserServiceImplementation(userRepository, passwordEncoder, roleRepository);
    }

    @Test
    void itShouldCheckIfSavingANewUserIsSavedCorrectly() {
        //given
        UserDto userDto = new UserDto("Jamila", "Henderson", "jamila@yahoo.com", "0723123234", "username", "jamila");
        //when
        when(passwordEncoder.encode("jamila")).thenReturn("jamilaCriptat");
        when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(new Role());

        //then
        Userr expectedResult =
                new Userr(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPhoneNumber(), userDto.getUsername(), "jamilaCriptat");
        Userr actualResult = underTest.saveUser(userDto);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void itShouldCheckIfUsernameExists() {
        //given
        String username = "livu";
        Userr user = new Userr("Livu", "Botea", "livu@yahoo.com", "0748531442", username, "emi");

        //when
        when(userRepository.findByUsername(username)).thenReturn(user);

        //then
        Userr actualResult = underTest.findUserByUsername(username);
        assertThat(actualResult).isEqualTo(user);
    }

    @Test
    @Disabled
    void findAllUsers() {
    }
}

// Integration test  - Setup complet al bazei de date
// Unit test - Testezi fiecare clasa in parte, iar comportamentul claselor externe il controlezi tu