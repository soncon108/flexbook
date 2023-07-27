package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Message;
import com.thanhson.flexbookjava.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageFaker {

    private static Faker faker;

    public MessageFaker() {
        this.faker = new Faker();
    }

    public Message createMessage(User sender, User receiver) {
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setMessage(faker.lorem().sentence());
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        return message;
    }
}
