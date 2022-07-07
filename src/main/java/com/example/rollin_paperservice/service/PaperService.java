package com.example.rollin_paperservice.service;


import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;

import java.util.List;

public interface PaperService {
    List<PaperEntity> getAllPaper();

    List<PaperEntity> getPaperByUserId(String id);
    Boolean postPaper(RequestPostDTO requestPostDTO);

    //CircuitBreaker를 위한 지연 삽입
    Boolean postDelayPaper(RequestPostDTO requestPostDTO);
}
