package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Like;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LikeFaker {

    private static Faker faker;

    public LikeFaker() {
        this.faker = new Faker();
    }

    public Like createLike(User user, Post post) {
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setCreatedAt(LocalDateTime.now());
        return like;
    }
}
