package com.airfrance.test.model;

import com.airfrance.test.enums.Gender;
import com.airfrance.test.model.Country;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    
    private String id;


    private String username;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    
    private String phoneNumber;
    
    private Gender gender;
    
    private Country country;
}
