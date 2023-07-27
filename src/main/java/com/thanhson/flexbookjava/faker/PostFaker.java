package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostFaker {

    private static Faker faker;

    public PostFaker() {
        this.faker = new Faker();
    }

    public Post createPost(User user) {
        Post post = new Post();
        post.setUser(user);
        post.setContent(faker.lorem().paragraph());
        post.setPostImage(faker.internet().image());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return post;
    }
}
