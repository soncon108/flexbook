package com.thanhson.flexbookjava.repository;

import com.thanhson.flexbookjava.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface friendRepository extends JpaRepository<Friend, Long> {
}