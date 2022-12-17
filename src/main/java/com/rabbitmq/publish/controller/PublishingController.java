package com.rabbitmq.publish.controller;

import com.rabbitmq.publish.dto.SampleData;
import com.rabbitmq.publish.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublishingController {

    @Autowired
    PublishingService publishingService;

    @GetMapping("/")
    public ResponseEntity<Object> hello(){
        return new ResponseEntity<>("Welcome To Message Publisher", HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<Object> sendMessage(@RequestBody SampleData sampleData){
        publishingService.publishMessage(sampleData);
        return new ResponseEntity<>("Sent",HttpStatus.OK);
    }

}
