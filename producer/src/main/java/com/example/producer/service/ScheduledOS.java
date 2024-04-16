package com.example.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.producer.model.dto.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
public class ScheduledOS {
//    private final ProducerService producerService;
//    private final Map<Integer, String> ordersMap = new HashMap<>();
//    private final Random random = new Random();
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Autowired
//    public ScheduledOS(ProducerService producerService){
//        this.producerService = producerService;
//    }
//
//    public void setOrdersMap() {
//        ordersMap.put(1, "{\"orderName\":\"KFC 6 pc Hot & Crispy Chicken\",\"orderQuantity\":\"2\",\"orderAmount\":\"628.57\"}");
//        ordersMap.put(2, "{\"orderName\":\"All in One Bucket\",\"orderQuantity\":\"3\",\"orderAmount\":\"548.57\"}");
//        ordersMap.put(3, "{\"orderName\":\"Bucket for Two\",\"orderQuantity\":\"1\",\"orderAmount\":\"599.05\"}");
//        ordersMap.put(4, "{\"orderName\":\"Stay Home Bucket\",\"orderQuantity\":\"1\",\"orderAmount\":\"788.57\"}");
//        ordersMap.put(5, "{\"orderName\":\"Peri Peri 10 Leg pc & 4 Dips\",\"orderQuantity\":\"2\",\"orderAmount\":\"924.76\"}");
//        ordersMap.put(6, "{\"orderName\":\"Peri Peri 5 Leg Pc Meal\",\"orderQuantity\":\"2\",\"orderAmount\":\"628.57\"}");
//        ordersMap.put(7, "{\"orderName\":\"Peri Peri 5 Leg Pc & 2 Dips\",\"orderQuantity\":\"4\",\"orderAmount\":\"515.24\"}");
//        ordersMap.put(8, "{\"orderName\":\"Big 12\",\"orderQuantity\":\"3\",\"orderAmount\":\"748.57\"}");
//        ordersMap.put(9, "{\"orderName\":\"Ultimate Savings Bucket\",\"orderQuantity\":\"3\",\"orderAmount\":\"699.05\"}");
//        ordersMap.put(10, "{\"orderName\":\"Big 8\",\"orderQuantity\":\"1\",\"orderAmount\":\"684.76\"}");
//        ordersMap.put(11, "{\"orderName\":\"5pc Smoky Red Chicken\",\"orderQuantity\":\"4\",\"orderAmount\":\"528.57\"}");
//        ordersMap.put(12, "{\"orderName\":\"Mingles Bucket Meal\",\"orderQuantity\":\"1\",\"orderAmount\":\"499.05\"}");
//        ordersMap.put(13, "{\"orderName\":\"8 pc Hot & Crispy Chicken\",\"orderQuantity\":\"1\",\"orderAmount\":\"768.57\"}");
//        ordersMap.put(14, "{\"orderName\":\"6 pc Hot & Crispy Chicken\",\"orderQuantity\":\"2\",\"orderAmount\":\"628.57\"}");
//    }
//
//    private int getRandomOrderId() {
//        setOrdersMap();
//        int randomIndex = random.nextInt(ordersMap.size());
//        return ordersMap.keySet().stream().skip(randomIndex).findFirst().orElse(0);
//    }
//
//    public String getRandomItemFromMenu() {
//        int randomOrderId = getRandomOrderId();
//        return ordersMap.get(randomOrderId);
//    }
//
//    @Scheduled(fixedRate = 1000) // Execute every 1 second
//    public String produceFoodOrder() throws JsonProcessingException {
//        String randomOrderJson = getRandomItemFromMenu();
//        ObjectMapper objectMapper = new ObjectMapper();
//        FoodOrder foodOrder = objectMapper.readValue(randomOrderJson, FoodOrder.class);
//        return producerService.produceOrderMessage(foodOrder);
//    }
}
