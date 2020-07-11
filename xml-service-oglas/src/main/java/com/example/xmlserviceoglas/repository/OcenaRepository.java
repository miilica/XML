package com.example.xmlserviceoglas.repository;

import com.example.xmlserviceoglas.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

    List<Ocena> findAllByVoziloId(Long voziloId);
}
