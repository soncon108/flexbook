package com.thanhson.flexbookjava.repository;

import com.thanhson.flexbookjava.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface likeRepository extends JpaRepository<Like, Long> {
}