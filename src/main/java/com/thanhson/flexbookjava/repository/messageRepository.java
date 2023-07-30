package com.thanhson.flexbookjava.repository;

import com.thanhson.flexbookjava.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface messageRepository extends JpaRepository<Message, Long> {
}