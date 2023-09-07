package com.jwtpractise.controller;

import com.jwtpractise.model.User;
import com.jwtpractise.service.appuser.IUserService;
import com.jwtpractise.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private JwtService jwtService;


    @GetMapping
    public ResponseEntity<User> get(@RequestHeader String Authorization){
        User user = getUserFromAuthentication(Authorization);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    private User getUserFromAuthentication(String authentication) {
        String jwt= authentication.trim().replace("Bearer ","");
        String name=jwtService.getUserNameFromJwtToken(jwt);
        User user= userService.findByName(name);
        return user;
    }
}
