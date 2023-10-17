package com.try_security.dao;

import com.try_security.entity.CompositeKey;
import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class User_OrderDAOImpl implements User_OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User_Order> getOrders(User user, String belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query = session.createQuery("FROM User_Order WHERE user =:user AND belonging=:belonging", User_Order.class);
        query.setParameter("user", user);
        query.setParameter("belonging", belonging);
        return query.getResultList();
    }

    @Override
    public List<User_Order> getOrders(String belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query = session.createQuery("FROM User_Order WHERE belonging =:belonging");
        query.setParameter("belonging", belonging);
        return query.getResultList();
    }

    @Override
    public List<User_Order> getOrders(Order order, String belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query = session.createQuery("FROM User_Order WHERE order=:order AND belonging=:belonging", User_Order.class);
        query.setParameter("order", order);
        query.setParameter("belonging", belonging);
        return query.getResultList();
    }

    @Override
    public void setUser_Order(Order order, String belonging, int count) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query = session.createQuery("FROM User_Order WHERE order=:order AND belonging=:belonging");
        query.setParameter("order", order);
        query.setParameter("belonging", belonging);
        User_Order userOrder = query.getResultList().get(0);
        userOrder.setCount(userOrder.getCount() - count);
        if(userOrder.getCount() == 0){
            Query<User_Order> query1 = session.createQuery("DELETE FROM User_Order WHERE order=:order AND belonging=:belonging");
            query1.setParameter("order", order);
            query1.setParameter("belonging", belonging);
            query1.executeUpdate();
        }
        session.saveOrUpdate(userOrder);
    }

    @Override
    public void setUser_Order(User user, Order order, String belonging, int count) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query2 = session.createQuery("FROM User_Order WHERE user=:user AND order=:order AND belonging=:belonging");
        query2.setParameter("order", order);
        query2.setParameter("user", user);
        query2.setParameter("belonging", belonging);
        if (query2.getResultList().size() == 0) {
            User_Order user_order = new User_Order();
            user_order.setUser(user);
            user_order.setBelonging(belonging);
            user_order.setCount(count);
            user_order.setOrder(order);
            session.save(user_order);
        } else {
            User_Order user_order = query2.getResultList().get(0);
            user_order.setCount(user_order.getCount() + count);
            session.saveOrUpdate(user_order);
        }
    }
    @Override
    public void deleteUser_Order(User user, Order order, String belonging){
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query2 = session.createQuery("FROM User_Order WHERE user=:user AND order=:order AND belonging=:belonging");
        query2.setParameter("order", order);
        query2.setParameter("user", user);
        query2.setParameter("belonging", belonging);
        User_Order user_order = query2.getResultList().get(0);
        session.remove(user_order);
    }

    @Override
    public void deleteUser_Order(User user, String belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query2 = session.createQuery("DELETE FROM User_Order WHERE user=:user AND order=:order AND belonging=:belonging");
        query2.setParameter("user", user);
        query2.setParameter("belonging", belonging);
        query2.executeUpdate();
    }

    @Override
    public void updateUser_Order(User user, Order order, String new_belonging, String old_belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query2 = session.createQuery("FROM User_Order WHERE user=:user AND order=:order AND belonging=:belonging");
        query2.setParameter("order", order);
        query2.setParameter("user", user);
        query2.setParameter("belonging", old_belonging);
        User_Order user_order = query2.getResultList().get(0);
        user_order.setBelonging(new_belonging);
        session.saveOrUpdate(user_order);
    }

    @Override
    public User_Order getUser_Order(User user, Order order, String belonging) {
        Session session = sessionFactory.getCurrentSession();
        Query<User_Order> query = session.createQuery("FROM User_Order WHERE user=:user AND order=:order AND belonging=:belonging");
        query.setParameter("user", user);
        query.setParameter("order", order);
        query.setParameter("belonging", belonging);
        return query.getResultList().get(0);
    }

}