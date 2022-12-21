package com.users.test.model.dto;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * User Data Trasnfer Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    /**
     * Identifier
     */
    private String id;

    /**
     * Username (Unique and not empty or blank)
     */
    @NotBlank(message = "UserName should not be blank")
    @NotEmpty(message = "UserName should not be empty")
    @NotNull(message = "Username should not be null")
    private String username;

    /**
     * BirdthDate (Should not be null)
     */
    @NotNull(message = "Birth Date should not be null")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    /**
     * PhoneNumber
     */
    private String phoneNumber;

    /**
     * Gender
     */
    private Gender gender;

    /**
     * Country
     */
    @NotNull(message = "Country should not be null")
    private Country country;
}
