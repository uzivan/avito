package com.try_security.dao;

import com.try_security.entity.Order;
import com.try_security.entity.User_Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderDAOImpl implements OrderDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Order getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public void setOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
    }
}
