package com.alkimsoft.sandbox.dao.core;

import com.alkimsoft.sandbox.representation.core.BaseEntity;
import com.alkimsoft.sandbox.representation.entities.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by gunerkaanalkim on 14/03/16.
 */
public class BaseDAO<T extends BaseEntity> extends AbstractDAO<T> {

    public BaseDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<T> findAll(Class<T> t) {

        Criteria criteria = currentSession().createCriteria(t);

        return list(criteria);
    }

    public T create(T entity) {
        return persist(entity);
    }

    public T findById(String oid) {
        return get(oid);
    }

    public T update(T entity) {
        return persist(entity);
    }

    public T delete(T entity) {
        currentSession().delete(entity);
        return entity;
    }

    public void flush() {
        currentSession().flush();
    }

    public T merge(T entity) {
        return (T) currentSession().merge(entity);
    }

    public T detach(T entity) {
        currentSession().evict(entity);
        return entity;
    }


}