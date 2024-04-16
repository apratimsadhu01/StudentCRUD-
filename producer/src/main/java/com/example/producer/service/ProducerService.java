package com.example.producer.service;

import com.example.producer.model.dto.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Component
public class ProducerService {
    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String produceOrderMessage(FoodOrder foodOrder) throws JsonProcessingException{
        String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
        kafkaTemplate.send(orderTopic, orderAsMessage);
        log.info("Food Order Produced {}", orderAsMessage);
        return "Message sent successfully";
    }


}
