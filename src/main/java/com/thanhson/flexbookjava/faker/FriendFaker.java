package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Friend;
import com.thanhson.flexbookjava.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FriendFaker {

    private static Faker faker;

    public FriendFaker() {
        this.faker = new Faker();
    }

    public Friend createFriend(User user1, User user2, User actionUser) {
        Friend friend = new Friend();
        friend.setUser1(user1);
        friend.setUser2(user2);
        friend.setStatus(faker.options().option("pending", "accepted", "rejected"));
        friend.setActionUser(actionUser);
        friend.setCreatedAt(LocalDateTime.now());
        friend.setUpdatedAt(LocalDateTime.now());
        return friend;
    }
}