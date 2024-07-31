package com.example.order_service.controller;

import com.example.order_service.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${app.kafka.kafkaOrderTopic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, OrderEvent> orderEventKafkaTemplate;

    @PostMapping("/add")
    public void addOrder(OrderEvent order) {
        orderEventKafkaTemplate.send(topicName, order);
    }

}
