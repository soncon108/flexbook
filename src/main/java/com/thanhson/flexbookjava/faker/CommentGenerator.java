package com.thanhson.flexbookjava.faker;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.Comment;
import com.thanhson.flexbookjava.model.Post;
import com.thanhson.flexbookjava.model.User;
import com.thanhson.flexbookjava.repository.commentRepository;

public class CommentGenerator {

    private static final int NUM_COMMENTS = 100;
    private static final Faker faker = new Faker();

    public static List<Comment> generateComments(commentRepository commentRepo, List<User> users, List<Post> posts) {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < NUM_COMMENTS; i++) {
            Comment comment = new Comment();
            comment.setUser(users.get(faker.random().nextInt(0, 9)));
            comment.setPost(posts.get(faker.random().nextInt(0, 49)));
            comment.setComment(faker.lorem().sentence());
            comment.setCreatedAt(TimestampGenerator.getRandomTimestamp());
            comment.setUpdatedAt(TimestampGenerator.getRandomTimestamp());
            comments.add(comment);
        }
        commentRepo.saveAll(comments);
        return comments;
    }

}
