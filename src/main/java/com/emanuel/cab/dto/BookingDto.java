package com.emanuel.cab.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {

    private Integer id;
    private String pickUpLocation;
    private String dropOffPoint;
    private Long createdAt;

}
