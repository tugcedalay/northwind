package com.tobeto.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
        User findByEmail(String email);
}
