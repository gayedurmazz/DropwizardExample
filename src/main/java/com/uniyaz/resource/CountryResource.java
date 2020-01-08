package com.uniyaz.resource;

import com.uniyaz.dao.CityDao;
import com.uniyaz.dao.CountryDao;
import com.uniyaz.entity.City;
import com.uniyaz.entity.Country;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/country")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CountryResource {

    private CountryDao countryDao;

    public CountryResource(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    // unitOfWork anotasyonu sessionu tutan transaction açar
    // @Valid ve @NotNull configure edilen nesnelerin üzerinde kullanılır.
    // kişi ıd ver departmanı gelsin vs.

    @GET
    @Path("/getAll")
    @UnitOfWork
    public List<Country> getAll(){
        return countryDao.getAllCountries();
    }


    // QUERYPARAM VE PATH PARAM ARASINDAKİ FARKA BAKILACAK !!
    // QueryParam path'te soru işareti ile verilen değeri alır.
    // PathParam

    @GET
    @Path("/findByCode")
    @UnitOfWork
    public Country findByCode(@QueryParam("code") String countryCode){
        return countryDao.findByCode(countryCode);
    }

    @DELETE
    @Path("/delete")
    @UnitOfWork
    public Response delete(@QueryParam("code") String code){
        countryDao.delete(countryDao.findByCode(code));
        return Response.status(202).entity("Employee deleted successfully !!").build();
    }


    @POST
    @Path("/insert")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Country insert(@BeanParam Country country){

        // BeanParam olduğu için country sınıfında her özelliğe formParam ekledik.

        if(country == null){
            throw new BadRequestException("Boş veri gönderilemez!");
        }

        Country addedCountry = countryDao.insert(country);
        return addedCountry;
    }
}
