package com.users.test.model.entity;

import com.users.test.enums.Country;
import com.users.test.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * User Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="USERS")
@Builder
public class User {
    @Id
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
