package com.repository;

import com.model.MarkaAutomobila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkaAutomobilaRepository extends JpaRepository<MarkaAutomobila, Long> {

    MarkaAutomobila findById(String id);
}
