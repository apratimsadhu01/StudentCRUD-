package com.example.consumer.model;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class FoodOrderDTO {
    Long orderId;
    String orderName;
    Integer orderQuantity;
    Double orderAmount;
}
