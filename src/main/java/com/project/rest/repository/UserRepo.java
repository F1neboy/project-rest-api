package com.project.rest.repository;

import com.project.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findUserByEmail(String email);

    List<User> findAll();
    User findUserById(Long id);
}
