package com.jwtpractise.repository;

import com.jwtpractise.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
