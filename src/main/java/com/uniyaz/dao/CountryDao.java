package com.uniyaz.dao;

import com.uniyaz.entity.Country;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

// AbstractDao'dan hazır crud işlemlerini aldık
public class CountryDao extends AbstractDAO<Country> {
    public CountryDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    // Criteria builder ile yazılmalı
    public List<Country> getAllCountries(){
        return (List<Country>) currentSession().createCriteria(Country.class).setMaxResults(5).list();
    }

    public Country findByCode(String code){
        return currentSession().get(Country.class, code);
    }

    public void delete(Country country){
        currentSession().delete(country);
    }

    public void update(Country country){
        currentSession().update(country);
    }

    public Country insert(Country country){
        return persist(country);
        // persist = save and update işlemi
    }

    // Kıtadaki şehirler
    // NEDEN ROOT ?
    public List<Country> getContinentCountries(String continent){
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Country>criteriaQuery = builder.createQuery(Country.class);
        Root<Country>root = criteriaQuery.from(Country.class);
        criteriaQuery.select(root).where(builder.equal(root.get("continent"), continent));
        Query<Country> query = currentSession().createQuery(criteriaQuery).setMaxResults(10);
        List<Country> countryList = query.list();
        return countryList;
    }
}
