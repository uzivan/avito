package com.try_security.dao;

import com.try_security.entity.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AuthorityDAOImpl implements AuthorityDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(Authority authority) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(authority);
    }
}
