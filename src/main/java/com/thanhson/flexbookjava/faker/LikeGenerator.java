package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Like;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.likeRepository;

public class LikeGenerator {

    private static final int NUM_LIKES = 200;
    private static final Faker faker = new Faker();

    public static List<Like> generateLikes(likeRepository likeRepo, List<User> users, List<Post> posts) {
        List<Like> likes = new ArrayList<>();
        for (int i = 0; i < NUM_LIKES; i++) {
            Like like = new Like();
            like.setUser(users.get(faker.random().nextInt(0, 9)));
            like.setPost(posts.get(faker.random().nextInt(0, 49)));
            like.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            likes.add(like);
        }
        likeRepo.saveAll(likes);
        return likes;
    }

}
