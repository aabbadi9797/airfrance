package com.airfrance.test.model;

import com.airfrance.test.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "UserName should not be blank")
    @NotEmpty(message = "UserName should not be empty")
    @NotNull(message = "Username should not be null")
    private String username;

    @NotNull(message = "Birth Date should not be null")
    private LocalDate birthDate;

    private String phoneNumber;
    
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="country_code")
    @NotNull(message = "Country should not be null")
    private Country country;
    
}
