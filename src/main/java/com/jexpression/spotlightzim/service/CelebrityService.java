package com.jexpression.spotlightzim.service;

import com.jexpression.spotlightzim.model.Celebrity;
import com.jexpression.spotlightzim.repository.CelebrityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CelebrityService {
    private final CelebrityRepository celebrityRepository;

    @Autowired
    public CelebrityService(CelebrityRepository celebrityRepository) {
        this.celebrityRepository = celebrityRepository;
    }



}