package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Friend;
import com.thanhson.flexbookjava.model.FriendStatus;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.friendRepository;

public class FriendGenerator {

    private static final int NUM_FRIENDS = 20;
    private static final Faker faker = new Faker();

    public static List<Friend> generateFriends(friendRepository friendRepo, List<User> users) {
        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < NUM_FRIENDS; i++) {
            Friend friend = new Friend();
            friend.setUser1(users.get(faker.random().nextInt(0, 9)));
            friend.setUser2(users.get(faker.random().nextInt(0, 9)));
            friend.setStatus(FriendStatus.values()[faker.random().nextInt(0, 2)]);
            friend.setActionUser(users.get(faker.random().nextInt(0, 9)));
            friend.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            friend.setUpdatedAt(TimestampGenerator.getRandomTimestamp());
            friends.add(friend);
        }
        friendRepo.saveAll(friends);
        return friends;
    }

}
