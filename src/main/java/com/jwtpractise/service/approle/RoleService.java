package com.jwtpractise.service.approle;

import com.jwtpractise.model.Role;
import com.jwtpractise.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Iterable<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role save(Role appRole) {
        return roleRepo.save(appRole);
    }

    @Override
    public void remove(Long id) {
    }
    @Override
    public Role findByUsername(String name) {
        return roleRepo.findByName(name);
    }
}
