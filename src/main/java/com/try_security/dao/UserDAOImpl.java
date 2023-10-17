package com.try_security.dao;

import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User get(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, name);
    }


//    @Override
//    @Transactional
//    public List<User_Order> getOrders(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.get(User.class, name);
//        return user.getUserOrders();
//    }

}
