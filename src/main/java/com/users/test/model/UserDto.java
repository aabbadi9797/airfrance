package com.users.test.model;

import com.users.test.enums.Gender;
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
