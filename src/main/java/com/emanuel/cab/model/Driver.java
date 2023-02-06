package com.emanuel.cab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "rating")
    private double rating;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
}
