package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Message;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.messageRepository;

public class MessageGenerator {

    private static final int NUM_MESSAGES = 100;
    private static final Faker faker = new Faker();

    public static List<Message> generateMessages(messageRepository messageRepo, List<User> users) {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < NUM_MESSAGES; i++) {
            Message message = new Message();
            message.setSender(users.get(faker.random().nextInt(0, 9)));
            message.setReceiver(users.get(faker.random().nextInt(0, 9)));
            message.setMessage(faker.lorem().sentence());
            message.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            message.setUpdatedAt(TimestampGenerator.getRandomTimestamp());
            messages.add(message);
        }
        messageRepo.saveAll(messages);
        return messages;
    }

}
