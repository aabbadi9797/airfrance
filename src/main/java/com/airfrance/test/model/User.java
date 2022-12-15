package com.airfrance.test.model;

import com.airfrance.test.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    
    @NotBlank(message = "UserName is mandatory")
    private String username;

    @NotBlank(message = "BirthDate is mandatory")
    private LocalDate birthDate;

    private String phoneNumber;
    
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="country_code")
    @NotBlank(message = "Country is mandatory")
    private Country country;
    
}
