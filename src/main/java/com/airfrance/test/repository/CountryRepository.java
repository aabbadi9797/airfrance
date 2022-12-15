package com.airfrance.test.repository;

import com.airfrance.test.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Character> {
    //Country findByCodeAndActive(Character code,boolean active);
}
