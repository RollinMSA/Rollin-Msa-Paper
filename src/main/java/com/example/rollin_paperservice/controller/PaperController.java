package com.example.rollin_paperservice.controller;

import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;
import com.example.rollin_paperservice.service.PaperService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;

    @Autowired
    PaperEntity paperEntity;
    @GetMapping
    public List<PaperEntity> getAllPaper(){
        return paperService.getAllPaper();
    }

    @GetMapping("/{userId}")
    public List<PaperEntity> getPaperByUserId(@PathVariable String userId) {
        System.out.println(userId);

        return paperService.getPaperByUserId(userId);
    }
    @PostMapping
    public Boolean postPaper(@RequestBody RequestPostDTO requestPostDTO){
        return paperService.postPaper(requestPostDTO);
    }
    @PostMapping("/delay")
    public Boolean postDelayPaper(@RequestBody RequestPostDTO requestPostDTO) {
        return paperService.postDelayPaper(requestPostDTO);
    }
}
