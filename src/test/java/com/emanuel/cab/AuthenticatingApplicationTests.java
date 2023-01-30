package com.emanuel.cab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
class AuthenticatingApplicationTests {

    private final Calculator calculator = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int firstNumber = 20;
        int secondNumber = 40;

        // when

        //then
        int result = calculator.add(firstNumber, secondNumber);
        int expected = 60;
        assertThat(result).isEqualTo(expected);
    }

    static class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
