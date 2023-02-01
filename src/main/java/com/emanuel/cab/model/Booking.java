package com.emanuel.cab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pick_up_location")
    private String pickUpLocation;
    @Column(name = "drop_off_point")
    private String dropOffPoint;
    @Column(name = "created_at")
    private Long createdAt;
//    @Column(name = "user_id")
//    @ManyToMany(mappedBy = "bookings")
//    @JoinColumn(name = "user_id")
//    private List<Userr> bookingUsers;

}
