package com.rabbitmq.publish.service;

import com.rabbitmq.publish.config.RabbitMQPublisherConfig;
import com.rabbitmq.publish.dto.SampleData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {

    @Autowired
    private RabbitTemplate template;

    public void publishMessage(SampleData sampleData){
        System.out.println("Lets do something");
        template.convertAndSend(RabbitMQPublisherConfig.EXCHANGE_NAME,RabbitMQPublisherConfig.ROUTING_KEY,sampleData);
    }

}
