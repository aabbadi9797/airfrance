package com.users.test.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * Util class for date operations and transformations
 */
public class DateUtils {
/**
 * Method to check if someone is adult or not based on its birthdate
 * @param birthDate
 * @return boolean
 */
    public static boolean isAdult(LocalDate birthDate){
        boolean adult = true;
        LocalDate now = LocalDate.now();
        if (Period.between(birthDate, now).getYears()<18){
            adult= false;
        }
        return adult;
    }
}
