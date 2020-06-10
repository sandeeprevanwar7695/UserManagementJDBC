package com.capital.user.manager.controller;

import com.capital.salt.exception.ApiException;
import com.capital.user.manager.model.User;
import com.capital.user.manager.service.UserManagerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManagementController {


    @Autowired
    UserManagerService userManagerService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() throws ApiException{
        List<User> list = userManagerService.getAllUsers();
        return new ResponseEntity<>(list,new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws ApiException{
        return new ResponseEntity<>(userManagerService.getUserById(id),new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) throws ApiException{

      User updated = userManagerService.createUser(user);
        return new ResponseEntity<>(updated,new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUSer(@RequestBody User user) throws ApiException{
        System.err.println("i am here " + user);

        User updated = userManagerService.updateUser(user);
        return new ResponseEntity<>(updated,new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id) throws  ApiException{
        userManagerService.deleteUserById(id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/all")
    public HttpStatus deleteAll() throws ApiException{
        userManagerService.deleteAll();
        return HttpStatus.OK;
    }
}
