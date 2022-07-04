package com.example.rollin_paperservice.model;

import lombok.Data;

@Data
public class RequestPostDTO {
    private Integer userId;
    private String content;
    private String nickname;
}
