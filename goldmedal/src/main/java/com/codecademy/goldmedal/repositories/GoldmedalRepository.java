package com.codecademy.goldmedal.repositories;


import org.springframework.data.repository.CrudRepository;

import com.codecademy.goldmedal.model.GoldMedal;
import java.util.List;



public interface GoldmedalRepository extends CrudRepository<GoldMedal, Long> {
    int countByCountry(String country);
    int countBySeason(String season);
    int countByCountryAndGender(String country, String gender);

    List<GoldMedal> getByCountryOrderByYearAsc(String country);
    List<GoldMedal> getByCountryOrderByYearDesc(String country);

    List<GoldMedal> getByCountryOrderBySeasonAsc(String country);
    List<GoldMedal> getByCountryOrderBySeasonDesc(String country);

    List<GoldMedal> getByCountryOrderByCityAsc(String country);
    List<GoldMedal> getByCountryOrderByCityDesc(String country);

    List<GoldMedal> getByCountryOrderByNameAsc(String country);
    List<GoldMedal> getByCountryOrderByNameDesc(String country);

    List<GoldMedal> getByCountryOrderByEventAsc(String country);
    List<GoldMedal> getByCountryOrderByEventDesc(String country);

    List<GoldMedal> getByCountryAndSeasonOrderByYearAsc(String country, String season);

}
