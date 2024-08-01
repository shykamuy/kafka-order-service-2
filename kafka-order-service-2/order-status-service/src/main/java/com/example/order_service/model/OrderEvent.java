package com.example.order_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class OrderEvent implements Serializable {

    private String product;

    private Integer quantity;

}
