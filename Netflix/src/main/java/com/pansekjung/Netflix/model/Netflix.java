package com.pansekjung.Netflix.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "NETFLIX")
public class Netflix {
    @Id
    @GeneratedValue
    private Long id;

    private String show_id;
    private String type;
    private String title;

    @Column(name="director", length = 1000)
    private String director;
    @Column(name="cast", length = 1000)
    private String cast;
    private String country;
    private String date_added;
    private Integer release_year;
    private String rating;
    private String duration;
    private String listed_in;
    private String description;
}

