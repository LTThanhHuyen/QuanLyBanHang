package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	User findByUsername(String username);
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    User findByUsernameAndPassword(String username,String password);
}
