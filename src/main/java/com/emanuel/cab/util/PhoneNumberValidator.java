package com.emanuel.cab.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final String PHONE_PATTERN = "/^(?:(?:(?:00\\s?|\\+)40\\s?|0)(?:7\\d{2}\\s?\\d{3}\\s?\\d{3}|(21|31)\\d{1}\\s?\\d{3}\\s?\\d{3}|((2|3)[3-7]\\d{1})\\s?\\d{3}\\s?\\d{3}|(8|9)0\\d{1}\\s?\\d{3}\\s?\\d{3}))$/";

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return validatePhoneNumber(phoneNumber);
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
