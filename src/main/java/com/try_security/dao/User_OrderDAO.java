package com.try_security.dao;

import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;

import java.util.List;

public interface User_OrderDAO {
    public List<User_Order> getOrders(User user, String belonging);
    public List<User_Order> getOrders(String belonging);
    public List<User_Order> getOrders(Order order, String belonging);
    public void setUser_Order(Order order, String belonging, int count);

    public void setUser_Order(User user, Order order, String belonging, int count);
    public User_Order getUser_Order(User user, Order order, String belonging);

    public void deleteUser_Order(User user, Order order, String belonging);

    public void deleteUser_Order(User user, String belonging);

    public void updateUser_Order(User user, Order order, String new_belonging, String old_belonging);
}
