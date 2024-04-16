package com.example.consumer.service;

import com.example.consumer.entity.FoodOrder;
import com.example.consumer.model.FoodOrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerService {
    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final FoodOrderService foodOrderService;

    public ConsumerService(ObjectMapper objectMapper, ModelMapper modelMapper, FoodOrderService foodOrderService){
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.foodOrderService = foodOrderService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeOrderMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        FoodOrderDTO foodOrderDTO = objectMapper.readValue(message, FoodOrderDTO.class);
        FoodOrder foodOrder = modelMapper.map(foodOrderDTO, FoodOrder.class);

        foodOrderService.saveOrderDetails(foodOrder);
    }
}
