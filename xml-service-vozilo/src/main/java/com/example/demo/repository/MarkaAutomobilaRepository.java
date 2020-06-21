package com.example.demo.repository;

import com.example.demo.model.MarkaAutomobila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkaAutomobilaRepository extends JpaRepository<MarkaAutomobila, Long> {
}
