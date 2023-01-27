package com.emanuel.cab.repository;

import com.emanuel.cab.model.Userr;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.when;

//@DataJpaTest
@AutoConfigureTestDatabase
class UserRepositoryTest {

    UserRepository userRepository;
    UserRepository underTest;

    @Test
    void itShouldCheckIfItCanFindByUsername() {
        //given
        String username = "livu";
        Userr expectedResult = new Userr("Livu", "Botea", "livu@yahoo.com", "0748531442", "livu", "emi");
        //when
        when(userRepository.findByUsername(username)).thenReturn(expectedResult);
        //then
        Userr actualResult = underTest.findByUsername(username);
    }
}