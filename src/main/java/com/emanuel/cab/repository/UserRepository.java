package com.emanuel.cab.repository;

import com.emanuel.cab.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr, Long> {
    Userr findByUsername(String username);
}
