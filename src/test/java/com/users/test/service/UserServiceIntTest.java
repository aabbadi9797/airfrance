package com.users.test.service;

import com.users.test.TestApplication;
import com.users.test.model.UserDto;
import com.users.test.enums.Gender;
import com.users.test.exception.FunctionalException;
import com.users.test.model.Country;
import com.users.test.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User Integration Test: Service Layer
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplication.class
)
@TestPropertySource(locations = "classpath:application.properties")
@RunWith(SpringRunner.class)
public class UserServiceIntTest {

    @Autowired
    IUserService userService;

/**
 * Create User Integration Test
 * @throws Exception
 */
    @Test
    public void createUserIntTest() throws FunctionalException {
        UserDto userDto = UserDto.builder().id("999").username("user999").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build();
        
        UserDto createdUserDto = userService.createUser(userDto);
        
        assertThat(createdUserDto.getId()).isSameAs(userDto.getId());
        
    }

/**
 * Get User By Id Integration Test
 * @throws FunctionalException
 */
    @Test
    public void getUserByIdIntTest() throws FunctionalException {
        User user = User.builder().id("1").build();
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").name("FRANCE").active(true).build()).phoneNumber("0612345678").gender(Gender.MALE).build();
        
        UserDto expectedUser = userService.getUserById(user.getId());
        
        assertThat(expectedUser).isEqualTo(userDto);
    }
    
}
