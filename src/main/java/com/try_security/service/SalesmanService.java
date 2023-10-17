package com.try_security.service;

import com.try_security.entity.User_Order;
import com.try_security.models.OrderForPage;

import java.util.List;

public interface SalesmanService {
    public List<OrderForPage> ordersOnSale();

    public void deleteOrder(int id);

    public List<OrderForPage> ordersFromUsers(String belonging);

}
