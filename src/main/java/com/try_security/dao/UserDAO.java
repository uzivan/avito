package com.try_security.dao;

import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;

import java.util.List;

public interface UserDAO {
    public void save(User user);

    public User get(String name);

//    public List<User_Order> getOrders(String name);

}
