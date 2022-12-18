package com.airfrance.test;

import com.airfrance.test.enums.Gender;
import com.airfrance.test.model.Country;
import com.airfrance.test.model.User;
import com.airfrance.test.repository.CountryRepository;
import com.airfrance.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
@RequiredArgsConstructor
public class TestApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final CountryRepository countryRepository;
/**
 * The main SpringBoot application
 * @param args
 */
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


/**
 * Inserting four users for test purpose
 * @param args
 * @throws Exception
 */
	@Override
	public void run(String... args) throws Exception {
		
		countryRepository.save(Country.builder().name("FRANCE").code("FRA").active(true).build());
		countryRepository.save(Country.builder().name("UNITED STATES").code("USA").active(true).build());
		
		userRepository.save(User.builder().id("1").username("user1").birthDate(LocalDate.parse("1997-11-04")).country(Country.builder().code("FRA").build()).phoneNumber("0612345678").gender(Gender.MALE).build());
		userRepository.save(User.builder().id("2").username("user2").birthDate(LocalDate.parse("1992-06-30")).country(Country.builder().code("FRA").build()).phoneNumber("0628549748").gender(Gender.MALE).build());
		userRepository.save(User.builder().id("3").username("user3").birthDate(LocalDate.parse("2004-12-04")).country(Country.builder().code("FRA").build()).phoneNumber("0634975276").gender(Gender.FEMALE).build());
		userRepository.save(User.builder().id("4").username("user4").birthDate(LocalDate.parse("1970-01-27")).country(Country.builder().code("FRA").build()).phoneNumber("0681094456").gender(Gender.FEMALE).build());
	}
}
