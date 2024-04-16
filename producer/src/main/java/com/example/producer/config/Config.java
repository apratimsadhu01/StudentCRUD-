package com.example.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.example.producer.model.AppConstants;
import org.springframework.scheduling.annotation.EnableScheduling;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@EnableScheduling
@Configuration
public class Config {
    private final KafkaProperties kafkaProperties;

    @Autowired
    public Config(KafkaProperties kafkaProperties){
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory(){
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.KAFKA_LOCAL_SERVER_CONFIG);
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.KafkaDemo.dto");
        return new DefaultKafkaProducerFactory<String, Object>(configMap);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("t.food.order")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}
