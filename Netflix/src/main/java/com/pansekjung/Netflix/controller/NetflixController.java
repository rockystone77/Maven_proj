package com.pansekjung.Netflix.controller;

import java.util.Optional;

import com.pansekjung.Netflix.model.Netflix;
import com.pansekjung.Netflix.repository.NetflixRepository;
import org.apache.commons.text.WordUtils;
import com.pansekjung.Netflix.model.NetflixDetailsResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RequestMapping("/netflix")
@RestController
public class NetflixController {
    private final NetflixRepository netflixRepository;

    public NetflixController(NetflixRepository netflixRepository){
        this.netflixRepository = netflixRepository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Netflix addNetflix(@RequestBody Netflix netflix){
        validateNewNetflix(netflix);

        return netflixRepository.save(netflix);
    }

    @GetMapping("/{id}")
    public Netflix getNetflix(@PathVariable Long id){
        Optional<Netflix> netflix = netflixRepository.findById(id);
        if (netflix.isPresent()){
            return netflix.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public Iterable<Netflix> getAllNetflix(){
        return netflixRepository.findAll();
    }

    @GetMapping("/{country}")
    public NetflixDetailsResponse searchNetflixByCountry(@RequestParam String country, @RequestParam Integer release_year){
        String countryName = WordUtils.capitalizeFully(country);
        return getNetflixDetailsResponse(countryName);
    }

    private void validateNewNetflix(Netflix netflix){
        if(ObjectUtils.isEmpty(netflix.getTitle())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Netflix> existingNetflix = netflixRepository.findNetflixByTitle(netflix.getTitle());
        if (existingNetflix.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    private NetflixDetailsResponse getNetflixDetailsResponse(String countryName){
        var countryOptional = netflixRepository.findNetflixByCountry(countryName);
        if(countryOptional.isEmpty()){
            return new NetflixDetailsResponse(countryName);
        }

        var country = 
    }
}
