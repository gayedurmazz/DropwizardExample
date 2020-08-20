package com.uniyaz.dao;

import com.uniyaz.entity.BaseEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

//////// Sadece BaseEntity'den türemiş sınıflar gelebilir.
public class BaseDao <T extends BaseEntity> extends AbstractDAO<T> {


    public BaseDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
