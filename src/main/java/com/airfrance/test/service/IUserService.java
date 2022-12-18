package com.airfrance.test.service;

import com.airfrance.test.model.UserDto;
import com.airfrance.test.exception.FunctionalException;

/**
 * User Service
 */
public interface IUserService {
/**
 * @param userDto
 * @return UserDto
 * @throws FunctionalException
 */
    UserDto createUser(UserDto userDto) throws FunctionalException;

/**
 * @param id
 * @return UserDto
 * @throws FunctionalException
 */
    UserDto getUserById(String id) throws FunctionalException;
}
