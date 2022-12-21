package com.users.test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Test program implements a SpringBoot application that
 * simply creates and displays a user.
 *
 * @author  ABBADI Ali
 * @version 2.4.0
 * @since   2022-12
 */
@SpringBootApplication
@EnableSwagger2
public class TestApplication {

/**
 * The main SpringBoot application
 * @param args
 */
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
