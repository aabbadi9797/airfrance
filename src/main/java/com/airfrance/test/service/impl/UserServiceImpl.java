package com.airfrance.test.service.impl;

import com.airfrance.test.exception.FunctionalException;
import com.airfrance.test.model.User;
import com.airfrance.test.repository.UserRepository;
import com.airfrance.test.service.IUserService;
import com.airfrance.test.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User createUser(User user) throws FunctionalException {
        if (!DateUtils.isAdult(user.getBirthDate())){
            throw new FunctionalException("Only Adult residents are allowed to create an account!");
        }
        if(!user.getCountry().getCode().equals("FRA")){
            throw new FunctionalException("Only French residents are allowed to create an account!");
        }
        if(userRepository.existsByUsername(user.getUsername())){
            throw new FunctionalException("Username Already Exists!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws FunctionalException {
        return userRepository.findById(id).orElseThrow(()-> new FunctionalException("User Not Found!"));
    }
}
