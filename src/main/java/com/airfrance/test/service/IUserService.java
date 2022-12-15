package com.airfrance.test.service;

import com.airfrance.test.exception.FunctionalException;
import com.airfrance.test.model.User;

public interface IUserService {
    User createUser(User user) throws FunctionalException;
    
    User getUserById(Long id) throws FunctionalException;
}
