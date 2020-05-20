package com.example.service;

import com.example.model.Poruka;

import java.util.List;

public interface PorukeService {
    Poruka findById(Long id);
    List<Poruka> findAllByReciverId(Long senderId);
    Poruka save(Poruka poruka);
}
