package com.thanhson.flexbookjava.repository;

import com.thanhson.flexbookjava.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface postRepository extends JpaRepository<Post, Long> {
}

