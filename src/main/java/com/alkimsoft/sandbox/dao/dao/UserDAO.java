package com.alkimsoft.sandbox.dao.dao;

import com.alkimsoft.sandbox.dao.core.BaseDAO;
import com.alkimsoft.sandbox.representation.entities.User;
import org.hibernate.SessionFactory;

/**
 * Created by gunerkaanalkim on 28/06/16.
 */
public class UserDAO extends BaseDAO<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
