package com.users.test.util;

import com.users.test.exception.FunctionalException;

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
    public static boolean isAdult(LocalDate birthDate) throws FunctionalException {
        try {
            boolean adult = true;
            LocalDate now = LocalDate.now();
            if (Period.between(birthDate, now).getYears()<18){
                adult= false;
            }
            return adult;
        }catch (Exception e){
            throw new FunctionalException("la date de naissance n'est pas valide!");
        }
      
    }
}
