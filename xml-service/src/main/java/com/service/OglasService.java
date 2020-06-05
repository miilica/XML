package com.service;

import com.dto.OglasDTO;
import com.dto.UserRegistrationDTO;
import com.model.Oglas;
import com.model.UserRequest;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface OglasService {
    Oglas findById(Long id);
    List<Oglas> findAll() throws AccessDeniedException;
    void delete(Long id);
}
