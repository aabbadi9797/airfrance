package com.users.test.controller;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.users.test.exception.FunctionalException;
import com.users.test.model.dto.UserDto;
import com.users.test.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 * User Unit Test: Controller Layer
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    
    
    @MockBean
    private UserServiceImpl userService;
    
    ObjectMapper objectMapper = new ObjectMapper();
 
/**
 * Create User Unit Test
 * @throws Exception
 */
    @Test
    void createUserTest() throws Exception {
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
    
        given(userService.createUser(userDto)).willReturn(userDto);
        
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonRequest = objectMapper.writeValueAsString(userDto);
        
        mockMvc.perform(post("/users/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())))
               .andExpect(MockMvcResultMatchers.jsonPath("$.country",CoreMatchers.is(userDto.getCountry().toString())));
    }

/**
 * Get User By Id Unit Test
 * @throws Exception
 */
    @Test
    void getUserByIdTest() throws Exception {
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.FRANCE).phoneNumber("0612345678").gender(Gender.MALE).build();
        given(userService.getUserById(userDto.getId())).willReturn(userDto);
        mockMvc.perform(get("/users/"+userDto.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())));
    }
}
