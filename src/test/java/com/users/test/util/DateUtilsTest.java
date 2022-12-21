package com.users.test.util;

import com.users.test.exception.FunctionalException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * DateUtils Test
 */
@SpringBootTest
public class DateUtilsTest {

/**
 * isAdult DateUtils test
 * @throws FunctionalException
 */
    @Test
    void isAdultTest() throws FunctionalException {
        LocalDate date1 = LocalDate.parse("1997-12-11");
        LocalDate date2 = LocalDate.parse("2006-09-01");
        boolean adult1 = DateUtils.isAdult(date1);
        boolean adult2 = DateUtils.isAdult(date2);
        assertThat(adult1).isTrue();
        assertThat(adult2).isFalse();
    }
    
}
