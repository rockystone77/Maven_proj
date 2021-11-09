package com.pansekjung.Netflix.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class NetflixDetailsResponse {
    private Long id;
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String date_added;
    private Integer release_year;
    private String rating;
    private String duration;
    private String listed_in;
    private String description;

    public NetflixDetailsResponse(String country){
        this.country = country;
    }

    public NetflixDetailsResponse(Long id,
                String show_id,
                String type,
                String title,
                String director,
                String cast,
                String country,
                String date_added,
                Integer release_year,
                String rating,
                String duration,
                String listed_in,
                String description){
this.id = id;
this.show_id = show_id;
this.type = type;
this.title = title;
this.director = director;
this.cast = cast;
this.country = country;
this.date_added = date_added;
this.release_year = release_year;
this.rating = rating;
this.duration = duration;
this.listed_in = listed_in;
this.description = description;
                }

}
