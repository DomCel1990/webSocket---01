package com.example.websocket01.controllers;

import com.example.websocket01.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class Notification {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody MessageDTO message){

        simpMessagingTemplate.convertAndSend("/broadcast/message",message);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
