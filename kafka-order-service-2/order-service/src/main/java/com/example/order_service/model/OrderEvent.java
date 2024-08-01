package com.example.order_service.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderEvent implements Serializable{

    private String product;

    private Integer quantity;

}
