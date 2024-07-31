package com.example.order_status_service.listener;

import com.example.order_status_service.model.OrderEventListened;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventListener {

    @KafkaListener(
            topics = "${app.kafka.kafkaOrderTopic}",
            groupId = "${app.kafka.kafkaOrderGroupId}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(OrderEventListened order) {
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
    }

}
