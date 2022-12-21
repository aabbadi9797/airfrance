package com.users.test.util;

import com.users.test.exception.FunctionalException;

import java.time.LocalDate;

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
            LocalDate today = LocalDate.now();
            return birthDate == null || (today.minusYears(18).compareTo(birthDate) >= 0);
        }catch (Exception e){
            throw new FunctionalException("la date de naissance n'est pas valide!");
        }
      
    }
}
