package com.service.impl;

import com.model.Agent;
import com.repository.AgentRepository;
import com.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public Agent findById(Long id) throws AccessDeniedException {
        Agent pom  = new Agent();
        Agent u = agentRepository.findById(id).orElse(pom);
        return u;
    }

}
