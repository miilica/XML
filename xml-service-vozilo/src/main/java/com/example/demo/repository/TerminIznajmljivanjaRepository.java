package com.example.demo.repository;

import com.example.demo.model.TerminIznajmljivanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminIznajmljivanjaRepository extends JpaRepository<TerminIznajmljivanja, Long> {
}
