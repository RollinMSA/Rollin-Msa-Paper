package com.example.rollin_paperservice.service;


import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;
import com.example.rollin_paperservice.repo.PaperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PaperServiceimpl implements PaperService {
    @Autowired
    PaperRepository paperRepository;


    @Override
    public List<PaperEntity> getAllPaper() {
        return paperRepository.findAll();
    }

    @Override
    public List<PaperEntity> getPaperByUserId(Integer userId) {
        return paperRepository.findAllByUserId(userId);
    }

    @Override
    public Boolean postPaper(RequestPostDTO requestPostDTO) {
        PaperEntity paperEntity = PaperEntity.builder()
                .userId(requestPostDTO.getUserId())
                .nickname(requestPostDTO.getNickname())
                .content(requestPostDTO.getContent())
                .date(LocalDateTime.now())
                .build();
        PaperEntity new_paper = paperRepository.save(paperEntity);
        return new_paper.getId() != null;
    }

}
