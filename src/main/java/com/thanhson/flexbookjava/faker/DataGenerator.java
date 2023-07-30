package com.thanhson.flexbookjava.faker;

import com.thanhson.flexbookjava.model.*;
import com.thanhson.flexbookjava.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private userRepository userRepo;

    @Autowired
    private postRepository postRepo;

    @Autowired
    private commentRepository commentRepo;

    @Autowired
    private likeRepository likeRepo;

    @Autowired
    private friendRepository friendRepo;

    @Autowired
    private messageRepository messageRepo;
    @Override
    public void run(String... args) throws Exception {
        List<User> users = UserGenerator.generateUsers(userRepo);

        List<Post> posts = PostGenerator.generatePosts(postRepo, users);

        List<Comment> comments = CommentGenerator.generateComments(commentRepo, users, posts);

        List<Like> likes = LikeGenerator.generateLikes(likeRepo, users, posts);

        List<Friend> friends = FriendGenerator.generateFriends(friendRepo, users);

        List<Message> messages = MessageGenerator.generateMessages(messageRepo, users);
    }
}