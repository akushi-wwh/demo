package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id){
        System.out.println("### hello");
        return "Hello " + id;
    }

    @GetMapping("/jpa")
    public String jpa() {
        Order order = new Order();
        order.setOrderName("Test Order");
        orderService.save(order);

        OrderDetail od1 = new OrderDetail();
        od1.setProductName("주문상세 1");
        od1.setOrder(order);
        orderService.save(od1);

        OrderDetail od2 = new OrderDetail();
        od2.setProductName("주문상세 2");
        od2.setOrder(order);
        orderService.save(od2);

        Iterable<Order> orders = orderService.getOrders();
        for(Order o : orders) {
            System.out.println("o => " + o);
        }

        Iterable<OrderDetail> orderDetails = orderService.getOrderDetails();
        for(OrderDetail od : orderDetails) {
            System.out.println("od => " + od);
        }

        return "success";
    }
}
