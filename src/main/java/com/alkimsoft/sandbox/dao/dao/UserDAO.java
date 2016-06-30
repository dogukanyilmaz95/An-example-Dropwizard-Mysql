package com.alkimsoft.sandbox.dao.dao;

import com.alkimsoft.sandbox.dao.core.BaseDAO;
import com.alkimsoft.sandbox.representation.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by gunerkaanalkim on 28/06/16.
 */
public class UserDAO extends BaseDAO<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> getAll() {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("deletingStatus",false));
        return list(criteria);
    }
    public User loginControl(String pass,String email) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("password",pass));
        criteria.add(Restrictions.eq("email",email));
        return uniqueResult(criteria);
    }
}