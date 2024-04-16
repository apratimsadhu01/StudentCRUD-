package com.example.consumer.service;

import com.example.consumer.entity.FoodOrder;
import com.example.consumer.repository.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository){
        this.foodOrderRepository = foodOrderRepository;
    }

    public void saveOrderDetails(FoodOrder foodOrder){
        FoodOrder savedOrderDetails = foodOrderRepository.save(foodOrder);
        log.info("Order saved successfully {}", savedOrderDetails);
    }
}
