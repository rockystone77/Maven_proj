package com.pansekjung.Netflix.repository;

import org.springframework.data.repository.CrudRepository;
import com.pansekjung.Netflix.model.Netflix;

import java.util.List;
import java.util.Optional;

public interface NetflixRepository extends CrudRepository<Netflix, Long> {
    Optional<Netflix> findNetflixByTitle(String title);
    Optional<Netflix> findNetflixByCountry(String title);
    
}
