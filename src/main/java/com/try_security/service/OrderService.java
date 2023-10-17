package com.try_security.service;

import com.try_security.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> showOnSaleOrder();

    public Order getOrder(int id);

    public void setOrder(Order order, int count);


}
