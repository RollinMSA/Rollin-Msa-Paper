package com.example.rollin_paperservice.service;


import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;
import com.example.rollin_paperservice.repo.PaperRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static java.util.Collections.emptyList;

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
    @CircuitBreaker(name="paperService",fallbackMethod ="getPaperByUserIdFallback" )
    public List<PaperEntity> getPaperByUserId(String userId) {
        if(!userId.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new RuntimeException("not Number Error");
        }
        return paperRepository.findAllByUserId(Integer.valueOf(userId));
    }

    @Override

    public Boolean postPaper(RequestPostDTO requestPostDTO) {
        PaperEntity paperEntity = PaperEntity.builder()
                .userId(requestPostDTO.getUserId())
                .nickname(requestPostDTO.getNickname())
                .content(requestPostDTO.getContent())
                .date(LocalDateTime.now())
                .giftId(requestPostDTO.getGiftId())
                .build();
        PaperEntity new_paper = paperRepository.save(paperEntity);
        return new_paper.getId() != null;
    }


    @Override
    @CircuitBreaker(name="paperService", fallbackMethod = "postDelayFallback")
    public Boolean postDelayPaper(RequestPostDTO requestPostDTO) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PaperEntity paperEntity = PaperEntity.builder()
                .userId(requestPostDTO.getUserId())
                .nickname(requestPostDTO.getNickname())
                .content(requestPostDTO.getContent())
                .date(LocalDateTime.now())
                .giftId(requestPostDTO.getGiftId())
                .build();
        PaperEntity new_paper = paperRepository.save(paperEntity);
        return new_paper.getId() != null;
    }

//    70%확률로 예외 발생
//    private void randomException() {
//        int randomInt = new Random().nextInt(10);
//
//        if(randomInt <= 7) {
//            throw new RuntimeException("failed");
//        }
//    }


    private List<PaperEntity> getPaperByUserIdFallback(Throwable t) { return emptyList();}

    private Boolean postDelayFallback(Throwable t) {return false;}
}
