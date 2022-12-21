package com.users.test.service;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.users.test.exception.FunctionalException;
import com.users.test.exception.RessourceNotFoundException;
import com.users.test.mapper.UserMapper;
import com.users.test.model.dto.UserDto;
import com.users.test.model.entity.User;
import com.users.test.repository.UserRepository;

import com.users.test.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

/**
 * User Unit Test: Service Layer
 */
@SpringBootTest
public class UserServiceTest {

    /**
     * User Repository
     */
    @Mock
    UserRepository userRepository;

    /**
     * User Mapper
     */
    @Mock
    UserMapper userMapper;

    /**
     * User Service
     */
    @InjectMocks
    UserServiceImpl userService;

/**
 * Initialize DB with data before each method anotated with @Test
 */
    @BeforeEach
    void init(){
        userRepository.save(User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build());
    }
    
/**
 * Create User Unit Test
 * @throws FunctionalException
 */
    @Test
    void createUserTest() throws FunctionalException {
        User user = User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
    
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        Mockito.when(userMapper.userDtoToUser(ArgumentMatchers.any(UserDto.class))).thenReturn(user);
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);
    
        UserDto createdUserDto = userService.createUser(userDto);
    
        assertThat(createdUserDto.getId()).isSameAs(userDto.getId());
        assertThat(createdUserDto.getCountry()).isSameAs(userDto.getCountry());
        Mockito.verify(userRepository).save(user);
    }

/**
 * Get User By Id Unit Test
 * @throws RessourceNotFoundException
 */
    @Test
    void getUserByIdTest() throws RessourceNotFoundException {
        User user = User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);
        
        UserDto expectedUser = userService.getUserById(user.getId());
        
        assertThat(expectedUser).isSameAs(userDto);
        Mockito.verify(userRepository).findById(user.getId());
    }
    
}
