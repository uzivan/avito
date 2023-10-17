package com.try_security.service;

import com.try_security.entity.Order;
import com.try_security.entity.User_Order;
import com.try_security.models.OrderForPage;

import java.util.List;

public interface CartService {
    public List<OrderForPage> getCartOrders();
    public void setOrder(int id);

    public void deleteOrder(int id);

    public void deleteOrders();

    public void updateBelonging();
}
