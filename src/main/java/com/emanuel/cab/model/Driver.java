package com.emanuel.cab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;


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
    private int phoneNumber;
    @Column(name = "rating")
    private String rating;
    @Column(name = "flag")
    private boolean flag;
    @Column(name = "driver_coordinate")
    private Point driverCoordinate;
}
