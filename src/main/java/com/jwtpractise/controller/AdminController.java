package com.jwtpractise.controller;

import com.jwtpractise.exception.ApiInputException;
import com.jwtpractise.model.User;
import com.jwtpractise.service.appuser.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private IUserService userService;
    @RequestMapping(method = RequestMethod.GET, value = "list")
    @ApiOperation(value = "Get List User")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = User.class),
        @ApiResponse(code = 403, message = "Access Denied")
    })
    public ResponseEntity<Iterable<User>>getAllUser(@RequestHeader String authorization){
        try{
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }catch(Exception e2){
            throw e2;
        }
    }

    @GetMapping("create")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("dsvsd", HttpStatus.OK);
    }
}
