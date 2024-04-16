package com.example.producer.service;

import com.example.producer.model.dto.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class ScheduledOrderService {
    private final ProducerService producerService;
    private final MongoTemplate mongoTemplate;
    private final Random random = new Random();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ScheduledOrderService(ProducerService producerService, MongoTemplate mongoTemplate) {
        this.producerService = producerService;
        this.mongoTemplate = mongoTemplate;
    }

    public FoodOrder getRandomOrderFromMongoDB() {
        long count = mongoTemplate.count(new Query(), FoodOrder.class, "ordersCollection");
        int randomIndex = random.nextInt((int) count);
        Query query = new Query().skip(randomIndex).limit(1);
        return mongoTemplate.findOne(query, FoodOrder.class, "ordersCollection");
    }

    @Scheduled(fixedRate = 1000)
    public void produceFoodOrder() throws JsonProcessingException {
        FoodOrder randomOrder = getRandomOrderFromMongoDB();
        producerService.produceOrderMessage(randomOrder);
    }
}
