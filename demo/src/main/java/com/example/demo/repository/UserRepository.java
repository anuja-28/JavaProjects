package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    void save(User user);
}
