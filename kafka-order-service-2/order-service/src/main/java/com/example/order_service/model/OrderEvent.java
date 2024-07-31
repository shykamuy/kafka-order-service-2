package com.example.order_service.model;

import lombok.Data;

@Data
public class OrderEvent {

    private String product;

    private Integer quantity;

}
