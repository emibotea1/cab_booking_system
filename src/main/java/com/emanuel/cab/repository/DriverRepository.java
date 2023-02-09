package com.emanuel.cab.repository;

import com.emanuel.cab.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("SELECT d FROM Driver d WHERE d.available='YES'")
    List<Driver> findAllDriversByAvailability();
}
