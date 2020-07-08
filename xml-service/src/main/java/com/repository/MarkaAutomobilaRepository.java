package com.repository;

import com.model.MarkaAutomobila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkaAutomobilaRepository extends JpaRepository<MarkaAutomobila, Long> {

    MarkaAutomobila findById(String id);

    List<MarkaAutomobila> findAllById(Long markId);
}
