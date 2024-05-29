package com.bitsbids.BITSBids.service;


import com.bitsbids.BITSBids.model.Message;
import com.bitsbids.BITSBids.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configuration
public class MessageService {
    @Autowired
    private MessageRepo messageRepository;


    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message>getBySenderName(String senderName){
        return messageRepository.findMessagesBySenderName(senderName);
    }
    public List<Message>getByReceiverName(String receiverName){
        return messageRepository.findMessagesByReceiverName(receiverName);
    }
    public List<Message>getByBoth(String senderName,String receiverName){
        return messageRepository.findMessagesBySenderNameAndReceiverName(senderName,receiverName);
    }
}
