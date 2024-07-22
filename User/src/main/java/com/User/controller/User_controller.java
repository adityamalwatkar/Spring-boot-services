package com.User.controller;

import com.User.entity.User;
import com.User.service_impl.User_service_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User_controller {

    @Autowired
    private User_service_impl user_service;

    @PostMapping(value = "/user/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user){
        User savedUser = user_service.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/User/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User resp = user_service.getUserById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/User/addAllUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> addAllUsers(@RequestBody List<User> users){
        List<User> resp = user_service.addAllUsers(users);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/User/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = user_service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping(value = "/User/UpdateUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> UpdateUser(@PathVariable Integer id, @RequestBody User user){
        User resp = user_service.updateUser(id, user);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
