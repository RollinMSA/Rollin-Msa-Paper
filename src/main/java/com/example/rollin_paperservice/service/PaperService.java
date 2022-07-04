package com.example.rollin_paperservice.service;


import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;

import java.util.List;

public interface PaperService {
    List<PaperEntity> getAllPaper();

    List<PaperEntity> getPaperByUserId(Integer id);
    Boolean postPaper(RequestPostDTO requestPostDTO);
}
