package com.jwtpractise.service.appuser;

import com.jwtpractise.model.DTO.ICountRole;
import com.jwtpractise.model.User;
import com.jwtpractise.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo appUserRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public User save(User appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    public void remove(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = appUserRepo.findByUsername(username);
        return userOptional.orElse(null);
    }

    @Override
    public User findByName(String name) {
        return appUserRepo.findByUsername(name).get();
    }

    @Override
    public Iterable<ICountRole> getRoleNumber() {
        return appUserRepo.getRoleNumber();
    }
}
