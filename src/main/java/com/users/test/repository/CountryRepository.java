package com.users.test.repository;

import com.users.test.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Country Repository
 */
@Repository
public interface CountryRepository extends MongoRepository<Country,String> {
}
