package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.postRepository;

public class PostGenerator {

    private static final int NUM_POSTS = 50;
    private static final Faker faker = new Faker();

    public static List<Post> generatePosts(postRepository postRepo, List<User> users) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < NUM_POSTS; i++) {
            Post post = new Post();
            post.setUser(users.get(faker.random().nextInt(0, 9)));
            post.setContent(faker.lorem().paragraph());
            post.setPostImage(faker.internet().image());
            post.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            post.setUpdatedAt(TimestampGenerator.getRandomTimestamp());
            posts.add(post);
        }
        postRepo.saveAll(posts);
        return posts;
    }

}