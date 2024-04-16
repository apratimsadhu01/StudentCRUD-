package com.example.producer.service;

import com.example.producer.model.dto.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Service
public class FoodOrderService {
    private final ProducerService producerService;

    @Autowired
    public FoodOrderService(ProducerService producerService, Map<Integer, String> ordersMap, Random random, ObjectMapper objectMapper){
        this.producerService = producerService;
    }

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException{
        return producerService.produceOrderMessage(foodOrder);
    }

}
