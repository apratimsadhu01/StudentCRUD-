package com.example.producer.controller;

import com.example.producer.model.dto.FoodOrder;
import com.example.producer.service.FoodOrderService;
import com.example.producer.service.ScheduledOS;
import com.example.producer.service.ScheduledOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class FoodOrderController {
    private final FoodOrderService foodOrderService;
    private final ScheduledOrderService scheduledOrderService;
    private final ScheduledOS scheduledOS;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService, ScheduledOrderService scheduledOrderService, ScheduledOS scheduledOS) {
        this.foodOrderService = foodOrderService;
        this.scheduledOrderService = scheduledOrderService;
        this.scheduledOS = scheduledOS;
    }

    @PostMapping("/createOrder")
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }

//    @GetMapping("/startOrderProcess")
//    public String startScheduledProcess() throws JsonProcessingException {
//        scheduledOS.produceFoodOrder();
//        return "Started generating orders";
//    }

    @GetMapping("/startOrderProcess")
    public String startScheduledProcess() throws JsonProcessingException {
        scheduledOrderService.produceFoodOrder();
        return "Started generating orders";
    }
}
