package com.example.order_service.controller;

import com.example.order_service.model.OrderStatusEvent;
import com.example.order_service.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderStatusController {

    @Autowired
    private OrderStatusService service;

    @Autowired
    private KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    @Value("${app.kafka.kafkaOrderStatusTopic}")
    private String topicName;


    public void addOrderStatus(@RequestBody OrderStatusEvent status) {
        kafkaTemplate.send(topicName, status);
        service.add(status);
    }

}
