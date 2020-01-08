package com.uniyaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends BaseEntity {

    @Id
    @Column(name = "ID", columnDefinition = "int")
    @JsonProperty
    private int id;

    @Column(name = "Name", columnDefinition = "char")
    @JsonProperty
    private String name;

    @Column(name = "CountryCode", columnDefinition = "char")
    @JsonProperty
    private String countryCode;

    @Column(name = "Population", columnDefinition = "int")
    @JsonProperty
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
