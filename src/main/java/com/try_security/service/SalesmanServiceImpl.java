package com.try_security.service;

import com.try_security.dao.OrderDAO;
import com.try_security.dao.UserDAO;
import com.try_security.dao.User_OrderDAO;
import com.try_security.entity.Order;
import com.try_security.entity.User;
import com.try_security.entity.User_Order;
import com.try_security.models.OrderForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalesmanServiceImpl implements SalesmanService{
    @Autowired
    private User_OrderDAO user_orderDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Override
    @Transactional
    public List<OrderForPage> ordersOnSale() {
        List<OrderForPage> orderForPages = new ArrayList<>();
        List<User_Order> userOrders = user_orderDAO.getOrders(userDAO.get(name()), "OnSale");
        for(int i = 0;i<userOrders.size();i++){
            OrderForPage orderForPage = new OrderForPage();
            orderForPage.setName(userOrders.get(i).getOrder().getName());
            orderForPage.setId(userOrders.get(i).getOrder().getId());
            orderForPage.setCount(userOrders.get(i).getCount());
            orderForPage.setPrice(userOrders.get(i).getOrder().getPrice());
            orderForPages.add(orderForPage);
        }
        return orderForPages;
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        Order order = orderDAO.getOrder(id);
        User user = userDAO.get(name());
        int count = user_orderDAO.getUser_Order(user, order, "OnSale").getCount() * (-1);
        user_orderDAO.setUser_Order(user,order, "OnSale", count);
    }

    @Override
    @Transactional
    public List<OrderForPage> ordersFromUsers(String belonging) {
        List<OrderForPage> orderForPages = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<User_Order> userOrders = user_orderDAO.getOrders(userDAO.get(name()), "OnSale");
        for(int i = 0;i<userOrders.size();i++){
            orders.add(userOrders.get(i).getOrder());
        }
        for(int i = 0;i<orders.size();i++){
            List<User_Order> userOrders1 = user_orderDAO.getOrders(orders.get(i), belonging);
            int count=0;
            for(int j = 0;j<userOrders1.size();j++){
                count = count + userOrders1.get(j).getCount();
            }
            OrderForPage orderForPage = new OrderForPage();
            orderForPage.setName(orders.get(i).getName());
            orderForPage.setId(orders.get(i).getId());
            orderForPage.setCount(count);
            orderForPage.setPrice(orders.get(i).getPrice());
            orderForPages.add(orderForPage);
        }
        return orderForPages;
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
