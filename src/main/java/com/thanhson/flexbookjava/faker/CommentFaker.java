package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Comment;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentFaker {

    private static Faker faker;

    public CommentFaker() {
        this.faker = new Faker();
    }

    public Comment createComment(User user, Post post) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setComment(faker.lorem().sentence());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        return comment;
    }
}