package com.example.order_service.service;

import com.example.order_service.model.OrderEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<OrderEvent> orders = new ArrayList<>();

    public void add(OrderEvent order) {
        orders.add(order);
    }

}
