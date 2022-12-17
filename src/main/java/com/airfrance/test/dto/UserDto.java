package com.airfrance.test.dto;

import com.airfrance.test.enums.Gender;
import com.airfrance.test.model.Country;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    
    private String id;


    private String username;

    private LocalDate birthDate;
    
    private String phoneNumber;
    
    private Gender gender;
    
    private Country country;
}
