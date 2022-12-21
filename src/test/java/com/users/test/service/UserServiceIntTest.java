package com.users.test.service;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.users.test.exception.FunctionalException;
import com.users.test.exception.RessourceNotFoundException;
import com.users.test.model.dto.UserDto;
import com.users.test.model.entity.User;
import com.users.test.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * User Integration Test: Service Layer
 */
@SpringBootTest
public class UserServiceIntTest {

    /**
     * User Service
     */
    @Autowired
    IUserService userService;


    /**
     * User Repository
     */
    @Autowired
    UserRepository userRepository;

/**
 * Initialize DB with data before each method anotated with @Test
 */
    @BeforeEach
    void init(){
        userRepository.save(User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build());
    }

/**
 * Create User Integration Test
 * @throws Exception
 */
    @Test
    void createUserIntTest() throws FunctionalException {
        UserDto userDto = UserDto.builder().id("999").username("user999").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        
        UserDto createdUserDto = userService.createUser(userDto);
        
        assertThat(createdUserDto.getId()).isSameAs(userDto.getId());
        assertThat(createdUserDto.getCountry()).isSameAs(userDto.getCountry());
    }

/**
 * Get User By Id Integration Test
 * @throws RessourceNotFoundException
 */
    @Test
    void getUserByIdIntTest() throws RessourceNotFoundException {
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        
        UserDto expectedUser = userService.getUserById("1");
        
        assertThat(expectedUser).isEqualTo(userDto);
    }

/**
 * Testing Exceptions
 */
@Test
void FunctionalExceptionTEst(){
    UserDto userExisted = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
    UserDto userUsa = UserDto.builder().id("1").username("user2").birthDate(LocalDate.parse("1997-11-04")).country(Country.USA).phoneNumber("0612345678").gender(Gender.MALE).build();
    UserDto userNotAdult = UserDto.builder().id("1").username("user3").birthDate(LocalDate.parse("2009-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
    
    Exception exception = assertThrows(FunctionalException.class, () -> {
        userService.createUser(userExisted);
    });
    String expectedMessage = "Username Already Exists!";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
    
    exception = assertThrows(FunctionalException.class, () -> {
        userService.createUser(userUsa);
    });
    expectedMessage = "Only French residents are allowed to create an account!";
    actualMessage = exception.getMessage();
    
    assertTrue(actualMessage.contains(expectedMessage));
    
    exception = assertThrows(FunctionalException.class, () -> {
        userService.createUser(userNotAdult);
    });
    expectedMessage = "Only Adult residents are allowed to create an account!";
    actualMessage = exception.getMessage();
    
    assertTrue(actualMessage.contains(expectedMessage));
    
    exception = assertThrows(FunctionalException.class, () -> {
        userService.createUser(null);
    });
    expectedMessage = "Fields required: Birthday, Username, Country!";
    actualMessage = exception.getMessage();
    
    assertTrue(actualMessage.contains(expectedMessage));
}
}
