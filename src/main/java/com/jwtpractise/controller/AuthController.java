package com.jwtpractise.controller;

import com.jwtpractise.model.Role;
import com.jwtpractise.model.User;
import com.jwtpractise.service.approle.RoleService;
import com.jwtpractise.service.appuser.IUserService;
import com.jwtpractise.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByName(user.getUsername());
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Set<Role> roles = user.getRoleSet();
        for (Role role : roles) {
            Role current = roleService.findByUsername(role.getName());
            if (current == null) {
                roleService.save(role);
            } else {
                role.setId(current.getId());
            }
        }
        userService.save(user);
        return ResponseEntity.ok(user);
    }
}
