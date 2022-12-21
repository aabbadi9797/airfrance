package com.users.test.service;

import com.users.test.exception.RessourceNotFoundException;
import com.users.test.model.dto.UserDto;
import com.users.test.exception.FunctionalException;

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
    UserDto getUserById(String id) throws RessourceNotFoundException;
}
