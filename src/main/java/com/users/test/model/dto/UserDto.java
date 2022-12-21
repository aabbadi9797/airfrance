package com.users.test.model.dto;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    
    private String id;

    @NotBlank(message = "UserName should not be blank")
    @NotEmpty(message = "UserName should not be empty")
    @NotNull(message = "Username should not be null")
    private String username;

    @NotNull(message = "Birth Date should not be null")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    
    private String phoneNumber;
    
    private Gender gender;

    @NotNull(message = "Country should not be null")
    private Country country;
}
