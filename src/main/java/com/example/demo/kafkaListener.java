package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class kafkaListener {

    @Autowired
    ProductRepository productRepository;

    @StreamListener(Processor.INPUT)
    public void onEvent(@Payload OrderPlaced orderPlaced){
        if(orderPlaced.getEventType().equals("OrderPlaced"))
        {
            System.out.println("=====");
            System.out.println(orderPlaced);
            System.out.println("=====");
        }
    }
}
