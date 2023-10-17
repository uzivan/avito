package com.try_security.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Column(name="enabled")
    private int enabled;
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
//    @OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "user")
//    private List<User_Order> userOrders;
//
//    public List<User_Order> getUserOrders() {
//        return userOrders;
//    }
//
//    public void setUserOrders(List<User_Order> userOrders) {
//        this.userOrders = userOrders;
//    }

    //    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "users_orders"
//            , joinColumns = @JoinColumn(name = "user_username")
//            , inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders;

//    public void addOrder(Order order){
//        orders.add(order);
//    }
//
//    public void deleteOrder(Order order){orders.remove(order);}
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public User(){}

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
