package com.example.rollin_paperservice.controller;

import com.example.rollin_paperservice.model.PaperEntity;
import com.example.rollin_paperservice.model.RequestPostDTO;
import com.example.rollin_paperservice.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return paperService.getPaperByUserId(Integer.valueOf(userId));
    }
    @PostMapping
    public Boolean postPaper(@RequestBody RequestPostDTO requestPostDTO){
        return paperService.postPaper(requestPostDTO);
    }
//    @PostMapping("/addGift")
//    public ResponseEntity<?> postGift(@RequestBody PaperEntity paperEntity){
//        //log.info(paperDto.toString());
//        HttpStatus httpStatus;
//        httpStatus=paperService.insertGiftInPaperAndUpdateGiftCount(paperEntity)? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
//
//        return new ResponseEntity<>(httpStatus);
//    }
}
