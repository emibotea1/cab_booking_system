package com.emanuel.cab.repository;

import com.emanuel.cab.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);
}
