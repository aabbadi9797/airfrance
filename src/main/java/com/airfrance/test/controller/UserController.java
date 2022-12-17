package com.airfrance.test.controller;

import com.airfrance.test.annotation.LogExecutionTime;
import com.airfrance.test.dto.UserDto;
import com.airfrance.test.model.User;
import com.airfrance.test.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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