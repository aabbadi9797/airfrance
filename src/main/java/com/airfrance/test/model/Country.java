package com.airfrance.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Country Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "COUNTRIES")
public class Country {
    @Id
    private String code;

    private String name;
    
    private boolean active;
}
