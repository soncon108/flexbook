package com.thanhson.flexbookjava.repository;

import com.thanhson.flexbookjava.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<Comment, Long> {
}
