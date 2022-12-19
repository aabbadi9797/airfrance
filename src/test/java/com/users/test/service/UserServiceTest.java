package com.users.test.service;

import com.users.test.TestApplication;
import com.users.test.model.UserDto;
import com.users.test.enums.Gender;
import com.users.test.exception.FunctionalException;
import com.users.test.mapper.UserMapper;
import com.users.test.model.Country;
import com.users.test.model.User;
import com.users.test.repository.UserRepository;

import com.users.test.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

/**
 * User Unit Test: Service Layer
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplication.class
)
public class UserServiceTest {
    
    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;


/**
 * Create User Unit Test
 * @throws FunctionalException
 */
    @Test
    public void createUserTest() throws FunctionalException {
        User user = User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build();
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build();
    
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        Mockito.when(userMapper.userDtoToUser(ArgumentMatchers.any(UserDto.class))).thenReturn(user);
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);
    
        UserDto createdUserDto = userService.createUser(userDto);
    
        assertThat(createdUserDto.getId()).isSameAs(userDto.getId());
        
        Mockito.verify(userRepository).save(user);
    }

/**
 * Get User By Id Unit Test
 * @throws FunctionalException
 */
    @Test
    public void getUserByIdTest() throws FunctionalException {
        User user = User.builder().id("1").build();
        UserDto userDto = UserDto.builder().id("1").build();
        
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);
        
        UserDto expectedUser = userService.getUserById(user.getId());
        
        assertThat(expectedUser).isSameAs(userDto);
        Mockito.verify(userRepository).findById(user.getId());
    }
    
}
