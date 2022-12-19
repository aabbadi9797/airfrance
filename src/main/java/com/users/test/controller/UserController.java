package com.users.test.controller;

import com.users.test.annotation.LogExecutionTime;
import com.users.test.model.UserDto;
import com.users.test.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * Rest Controller for the User
 */
@RestController
@RequestMapping("users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    
/**
 * User creation API
 * @param userDto
 * @return userDto
 */
    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @LogExecutionTime
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        try {
            return userService.createUser(userDto);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

/**
 * Get a user by its id
 * @param id
 * @return userDto
 */
    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @LogExecutionTime
    public UserDto getUserById(@PathVariable String id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}