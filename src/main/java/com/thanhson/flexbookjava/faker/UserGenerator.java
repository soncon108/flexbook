package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.userRepository;

public class UserGenerator {

    private static final int NUM_USERS = 10;
    private static final Faker faker = new Faker();

    public static List<User> generateUsers(userRepository userRepo) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < NUM_USERS; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfilePicture(faker.internet().avatar());
            user.setBio(faker.lorem().sentence());
            user.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            user.setUpdatedAt(TimestampGenerator.getRandomTimestamp());
            users.add(user);
        }
        userRepo.saveAll(users);
        return users;
    }

}
