package com.users.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * Country Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "COUNTRIES")
@Builder
public class Country {
    @Id
    private String code;

    private String name;
    
    private boolean active;
}
