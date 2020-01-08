package com.uniyaz.resource;

import com.uniyaz.dao.CityDao;
import com.uniyaz.dao.CountryDao;
import com.uniyaz.entity.City;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/city")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})

public class CityResource {

    private CityDao cityDao;

    public CityResource(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GET
    @Path("/population/{population}")
    @UnitOfWork
    public List<City> getCitiesByPopulation(@PathParam("population") int population) {
        return cityDao.getCitiesByPopulation(population);
    }

}
