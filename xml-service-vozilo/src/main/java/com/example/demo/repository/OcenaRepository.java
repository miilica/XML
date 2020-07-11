package com.example.demo.repository;

import com.example.demo.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {


    List<Ocena> findAllByVoziloId(Long voziloId);
}
