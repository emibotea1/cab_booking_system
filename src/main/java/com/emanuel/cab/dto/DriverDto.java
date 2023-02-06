package com.emanuel.cab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DriverDto {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String rating;
    private boolean available;
    private String latitude;
    private String longitude;
}
