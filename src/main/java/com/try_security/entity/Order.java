package com.try_security.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @TableGenerator(name = "user_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="description")
    private String description;

    public Order(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    //    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
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
//            , joinColumns = @JoinColumn(name ="order_id")
//            , inverseJoinColumns = @JoinColumn(name = "user_username"))
//    private List<Order> users;
    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Order> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Order> users) {
//        this.users = users;
//    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
