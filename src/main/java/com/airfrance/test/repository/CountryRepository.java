package com.airfrance.test.repository;

import com.airfrance.test.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Country Repository
 */
@Repository
public interface CountryRepository extends MongoRepository<Country,Character> {
}
