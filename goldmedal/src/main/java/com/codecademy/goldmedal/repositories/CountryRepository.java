package com.codecademy.goldmedal.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.codecademy.goldmedal.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
    Optional<Country> getByName(String name);

    List<Country> getAllByOrderByNameAsc();
    List<Country> getAllByOrderByNameDesc();

    List<Country> getAllByOrderByGdpAsc();
    List<Country> getAllByOrderByGdpDesc();

    List<Country> getAllByOrderByPopulationAsc();
    List<Country> getAllByOrderByPopulationDesc();
}
