package com.example.producer.model.dto;

import lombok.*;

import java.beans.ConstructorProperties;

@Data
@Value
@Builder
public class FoodOrder {
    String orderName;
    Integer orderQuantity;
    Double orderAmount;

    public FoodOrder(String orderName, Integer orderQuantity, Double orderAmount) {
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
        this.orderAmount = orderAmount;
    }
}
