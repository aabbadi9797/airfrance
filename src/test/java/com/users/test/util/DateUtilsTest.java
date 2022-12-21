package com.users.test.util;

import com.users.test.exception.FunctionalException;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * DateUtils Test
 */
class DateUtilsTest {

/**
 * isAdult DateUtils test
 * @throws FunctionalException
 */
    @Test
    void isAdultTest() throws FunctionalException {
        LocalDate date = LocalDate.parse("1997-12-11");
        boolean adult = DateUtils.isAdult(date);
        assertThat(adult).isTrue();
    }

    @Test
    void isNotAdultTest() throws FunctionalException {
        LocalDate date = LocalDate.parse("2006-09-01");
        boolean adult = DateUtils.isAdult(date);
        assertThat(adult).isFalse();
    }
    
}
