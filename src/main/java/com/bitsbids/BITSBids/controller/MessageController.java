package com.bitsbids.BITSBids.controller;

import com.bitsbids.BITSBids.model.Message;
import com.bitsbids.BITSBids.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @PostMapping("/message")
    public Message receiveMessage(@RequestBody Message message){
        messageService.saveMessage(message);
        return message;
    }
    @GetMapping("/messages")
    public List<Message> getMessage(){
        return messageService.getMessages();
    }
    @GetMapping("/messages/sender/{senderName}")
    public List<Message>getBySenderName(@PathVariable String senderName){
        return messageService.getBySenderName(senderName);
    }
    @GetMapping("/messages/receiver/{receiverName}")
    public List<Message>getByReceiverName(@PathVariable String receiverName){
        return messageService.getByReceiverName(receiverName);
    }
    @GetMapping("/messages/sender/{senderName}/receiver/{receiverName}")
    public List<Message>getByBoth(@PathVariable String senderName,@PathVariable String receiverName){
        return messageService.getByBoth(senderName,receiverName);
    }
}
