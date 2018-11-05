package com.example.demo.entity;

import javax.persistence.*;

@Entity(name="T_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="order_name")
    private String orderName;

    @Override
    public String toString() {
        return String.format("id=%s, orderName=%s", id, orderName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
