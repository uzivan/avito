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
public class CartServiceImpl implements CartService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private User_OrderDAO userOrderDAO;

    @Override
    @Transactional
    public List<OrderForPage> getCartOrders() {
        List<User_Order> userOrders = userOrderDAO.getOrders(userDAO.get(name()), "InCart");
        List<OrderForPage> orders = new ArrayList<>();
        for(int i = 0;i < userOrders.size();i++){
            OrderForPage orderForPage = new OrderForPage();
            orderForPage.setPrice(userOrders.get(i).getOrder().getPrice());
            orderForPage.setCount(userOrders.get(i).getCount());
            orderForPage.setId(userOrders.get(i).getOrder().getId());
            orderForPage.setName(userOrders.get(i).getOrder().getName());
            orders.add(orderForPage);
//            for(int j = 0;j < userOrders.get(i).getCount();j++){
//                orders.add(userOrders.get(i).getOrder());
//            }
        }
        return orders;
    }

    @Override
    @Transactional
    public void setOrder(int id) {
        System.out.println(orderDAO.getOrder(id));
        System.out.println(userDAO.get(name()));
        User user = userDAO.get(name());
        Order order = orderDAO.getOrder(id);
        userOrderDAO.setUser_Order(order, "OnSale", 1);
        userOrderDAO.setUser_Order(userDAO.get(name()), orderDAO.getOrder(id), "InCart", 1);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        User user = userDAO.get(name());
        Order order = orderDAO.getOrder(id);
        userOrderDAO.setUser_Order(user, order, "InCart", -1);
        userOrderDAO.setUser_Order(order, "OnSale", -1);
        if(userOrderDAO.getUser_Order(user, order, "InCart").getCount() == 0){
            userOrderDAO.deleteUser_Order(user, order, "InCart");
        }
    }

    @Override
    @Transactional
    public void deleteOrders() {
        userOrderDAO.deleteUser_Order(userDAO.get(name()), "InCart");
    }

    @Override
    @Transactional
    public void updateBelonging() {
        User user = userDAO.get(name());
        List<User_Order> orderList = userOrderDAO.getOrders(user, "InCart");
        for(int i = 0;i<orderList.size();i++){
            userOrderDAO.updateUser_Order(user, orderList.get(i).getOrder(), "Bought", "InCart");
        }
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
