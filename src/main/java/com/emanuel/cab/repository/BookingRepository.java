package com.emanuel.cab.repository;

import com.emanuel.cab.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {

}
