package com.try_security.service;

import com.try_security.dao.*;
import com.try_security.entity.Authority;
import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private User_OrderDAO userOrderDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<Order> showOnSaleOrder() {
        List<User_Order> userOrders = userOrderDAO.getOrders("OnSale");
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < userOrders.size(); i++){
            orders.add(userOrders.get(i).getOrder());
        }
        return orders;
    }

    @Override
    @Transactional
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    @Transactional
    public void setOrder(Order order, int count) {
        orderDAO.setOrder(order);
        userOrderDAO.setUser_Order(userDAO.get(name()), order, "OnSale", count);
    }

    public String name() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            System.out.println("Username: " + username);
        } else {
            username = principal.toString();
            System.out.println("Username: " + username);
        }
        return username;
    }

}
