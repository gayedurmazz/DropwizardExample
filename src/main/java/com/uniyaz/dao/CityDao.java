package com.uniyaz.dao;

import com.uniyaz.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CityDao extends BaseDao {
    public CityDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    //
    public List<City> getCitiesByPopulation(int population) {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        //select * from city
        CriteriaQuery<City> criteriaQuery = builder.createQuery(City.class);

        Root<City> root = criteriaQuery.from(City.class);
        criteriaQuery.select(root).where(builder.greaterThan(root.get("population").as(Integer.class), population));

        Query<City> query = currentSession().createQuery(criteriaQuery);

        List<City> cityList = query.list();
        return cityList;
    }
}
