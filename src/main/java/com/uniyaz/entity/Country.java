package com.uniyaz.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Entity
@Table(name = "country")
public class Country extends BaseEntity {

    // Column definition ile tip tanımlamaları yapılmalı!!!!
    @Id
    @Column(name = "Code", columnDefinition = "char")
    @JsonProperty
    @FormParam("code")
    private String code;

    @Column(name = "Name", columnDefinition = "char")
    @JsonProperty
    @FormParam("name")
    private String name;

    @Column(name = "Continent", nullable = false,columnDefinition = "enum")
    @JsonProperty
    @FormParam("continent")
    private String continent;

    @Column(name = "Region", columnDefinition = "char")
    @JsonProperty
    @FormParam("region")
    private String region;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
