package com.uniyaz;

import com.uniyaz.configuration.HibernateConfiguration;
import com.uniyaz.dao.CityDao;
import com.uniyaz.dao.CountryDao;
import com.uniyaz.entity.City;
import com.uniyaz.entity.Country;
import com.uniyaz.resource.CityResource;
import com.uniyaz.resource.CountryResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApp extends Application<HibernateConfiguration> {
    public static void main( String[] args ) throws Exception {
        new DropwizardApp().run(args);
    }

    private final HibernateBundle<HibernateConfiguration> hibernate = new HibernateBundle<HibernateConfiguration>(Country.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(HibernateConfiguration hibernateConfiguration) {
            return hibernateConfiguration.getDatabaseAppDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<HibernateConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(HibernateConfiguration hibernateConfiguration, Environment environment) throws Exception {

        final CountryDao countryDao = new CountryDao(hibernate.getSessionFactory());
        final CityDao cityDao = new CityDao(hibernate.getSessionFactory());


        final CountryResource countryResource = new CountryResource(countryDao);
        final CityResource cityResource = new CityResource(cityDao);

        environment.jersey().register(countryResource);
        environment.jersey().register(cityResource);
    }
}
