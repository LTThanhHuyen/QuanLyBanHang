package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order_Detail;

@Repository
public interface Order_DetailRepository extends JpaRepository<Order_Detail,Long>{

}
