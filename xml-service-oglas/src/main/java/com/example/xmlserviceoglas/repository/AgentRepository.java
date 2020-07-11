package com.example.xmlserviceoglas.repository;

import com.example.xmlserviceoglas.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
