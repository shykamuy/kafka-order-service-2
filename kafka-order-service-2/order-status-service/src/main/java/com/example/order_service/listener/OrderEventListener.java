package com.example.order_service.listener;

import com.example.order_service.controller.OrderStatusController;
import com.example.order_service.model.OrderEvent;
import com.example.order_service.model.OrderStatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class OrderEventListener implements Serializable {

    @Autowired
    private OrderStatusController controller;

    @KafkaListener(
            topics = "${app.kafka.kafkaOrderTopic}",
            groupId = "${app.kafka.kafkaOrderGroupId}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(
            @Payload OrderEvent message,
            @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) UUID key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp
    ) {
        log.info("Received message: {}", message);
        log.info("Key: {}; Partition: {}; Topic: {}; Timestamp: {}", key, partition, topic, timestamp);

        controller.addOrderStatus(new OrderStatusEvent("Created", Instant.now()));

    }

}
