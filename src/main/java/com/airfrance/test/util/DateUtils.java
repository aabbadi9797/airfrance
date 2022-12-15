package com.airfrance.test.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
    public static boolean isAdult(LocalDate birthDate){
        boolean adult = true;
        LocalDate now = LocalDate.now();
        if (Period.between(birthDate, now).getYears()<18){
            adult= false;
        }
        return adult;
    }
}
