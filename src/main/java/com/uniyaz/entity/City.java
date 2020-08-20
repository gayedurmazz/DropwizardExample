package com.uniyaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

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

    @Column(name = "Country")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", foreignKey = @ForeignKey(name = "FK_CITY_COUNTRY"))
    @JsonProperty
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
