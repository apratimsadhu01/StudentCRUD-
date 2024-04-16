package com.example.consumer.config;

import com.example.consumer.entity.FoodOrder;
import com.example.consumer.model.AppConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ConsumerFactory<String, FoodOrder> consumerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.KAFKA_LOCAL_SERVER_CONFIG);
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, AppConstants.GROUP_ID_JSON);
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.KafkaDemo.dto");
        return new DefaultKafkaConsumerFactory<>(configMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FoodOrder> kafkaListenerContainerFactory(){
            ConcurrentKafkaListenerContainerFactory<String, FoodOrder> factory = new ConcurrentKafkaListenerContainerFactory<String, FoodOrder>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
