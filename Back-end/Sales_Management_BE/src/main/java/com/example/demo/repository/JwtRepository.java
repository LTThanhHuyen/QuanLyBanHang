package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface JwtRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
