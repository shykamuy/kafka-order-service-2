package com.example.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
public class OrderStatusEvent implements Serializable {

    private String status;

    private Instant date;

}
