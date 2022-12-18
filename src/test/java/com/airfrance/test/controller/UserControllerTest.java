package com.airfrance.test.controller;

import com.airfrance.test.TestApplication;
import com.airfrance.test.dto.UserDto;
import com.airfrance.test.enums.Gender;
import com.airfrance.test.exception.FunctionalException;
import com.airfrance.test.model.Country;
import com.airfrance.test.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 * User Unit Test: Controller Layer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestApplication.class
)
public class UserControllerTest {

    private   MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    @MockBean
    private UserServiceImpl userService;
    
    ObjectMapper objectMapper = new ObjectMapper();

/**
 * Setting up the MockMvc with WebApplicationContext
 */
    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

/**
 * Create User Unit Test
 * @throws Exception
 */
    @Test
    public void createUserTest() throws Exception {
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build();
    
        given(userService.createUser(userDto)).willReturn(userDto);
        
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonRequest = objectMapper.writeValueAsString(userDto);
        
        mockMvc.perform(post("/users/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())));
    }

/**
 * Get User By Id Unit Test
 * @throws FunctionalException
 */
    @Test
    public void getUserByIdTest() throws Exception {
        UserDto userDto = UserDto.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build();
        given(userService.getUserById(userDto.getId())).willReturn(userDto);
        mockMvc.perform(get("/users/"+userDto.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())));
    }
}
