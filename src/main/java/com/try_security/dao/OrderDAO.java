package com.try_security.dao;

import com.try_security.entity.Order;

import java.util.List;

public interface OrderDAO {
//    public List<Order> getAl();
//
    public Order getOrder(int id);

    public void setOrder(Order order);

    public void deleteOrder(int id);
}
