package com.try_security.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_orders")
public class User_Order {
//    @EmbeddedId
//    private CompositeKey compositeKey;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name = "user_username")
    private User user;
    @ManyToOne(/*fetch = FetchType.LAZY*/)
    @JoinColumn(name="order_id")
    private Order order;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="belonging")
    private String belonging;
    @Column(name="count")
    private int count;


    public User_Order(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBelonging() {
        return belonging;
    }

    public void setBelonging(String belonging) {
        this.belonging = belonging;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

