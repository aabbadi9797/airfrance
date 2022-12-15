package com.airfrance.test.controller;

import com.airfrance.test.annotation.LogExecutionTime;
import com.airfrance.test.exception.FunctionalException;
import com.airfrance.test.model.User;
import com.airfrance.test.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
@Validated
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;
    
    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @LogExecutionTime
    public User createUser(@RequestBody @Valid User user) {
        try {
            return userService.createUser(user);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @LogExecutionTime
    public User getUserById(@PathVariable Long id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}