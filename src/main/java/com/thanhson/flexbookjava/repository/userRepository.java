package com.thanhson.flexbookjava.repository;


import com.thanhson.flexbookjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, String> {
}


