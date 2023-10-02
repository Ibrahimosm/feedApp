package com.bptn.feedApp.repository;
import com.bptn.feedApp.jpa.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>{

    Optional<User> findByUsername(String username);
    Optional<User> findByEmailId(String email);
}
