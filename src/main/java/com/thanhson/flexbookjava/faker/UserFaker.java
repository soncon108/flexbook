package com.thanhson.flexbookjava.faker;

import com.github.javafaker.Faker;
import com.thanhson.flexbookjava.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


import java.time.LocalDateTime;

public class UserFaker {
    private static  Faker faker = new Faker();

    public static void generateAndInsertDummyUsers(int numUsers) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        for (int i = 0; i < numUsers; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password(8, 16));
            user.setProfilePicture(faker.internet().image());
            user.setBio(faker.lorem().sentence());
            user.setCreatedAt(LocalDateTime.now().minusDays(faker.number().numberBetween(1, 365)));
            user.setUpdatedAt(LocalDateTime.now().minusDays(faker.number().numberBetween(1, 365)));

            entityManager.persist(user);
        }

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}