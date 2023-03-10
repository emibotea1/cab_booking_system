package com.emanuel.cab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer id;
    @Column(name = "pick_up_location")
    private String pickUpLocation;
    @Column(name = "drop_off_point")
    private String dropOffPoint;
    @Column(name = "created_at")
    private Long createdAt;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Userr users;
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver drivers;
}
