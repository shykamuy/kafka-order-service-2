package com.example.order_status_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderEventListened {

    private String product;

    private Integer quantity;

}
