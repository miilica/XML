package com.example.xmlserviceoglas.repository;

import com.example.xmlserviceoglas.model.Zauzece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ZauzeceRepository extends JpaRepository<Zauzece,Long> {
}
