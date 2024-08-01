package com.example.order_service.service;

import com.example.order_service.model.OrderStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStatusService {

    private final List<OrderStatusEvent> orderStatusEventList = new ArrayList<>();

    public void add(OrderStatusEvent event) {
        orderStatusEventList.add(event);
    }

}
