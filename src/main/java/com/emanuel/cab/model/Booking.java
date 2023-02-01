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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Integer id;
    @Column(name = "pick_up_location")
    private String pickUpLocation;
    @Column(name = "drop_off_point")
    private String dropOffPoint;
    @Column(name = "created_at")
    private Long createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Userr users;
}
