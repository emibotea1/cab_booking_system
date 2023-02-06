package com.emanuel.cab.repository;

import com.emanuel.cab.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {

}
