package com.pluralsight.fundamentals.entity;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Value
@Builder
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "release_id")
    private Integer id;

    private String releaseDate;
    private String description;
}
