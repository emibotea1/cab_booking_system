package com.emanuel.cab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pickUpLocation;
    private String dropOffPoint;
}
