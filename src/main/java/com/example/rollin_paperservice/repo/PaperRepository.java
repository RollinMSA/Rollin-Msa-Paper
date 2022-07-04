package com.example.rollin_paperservice.repo;


import com.example.rollin_paperservice.model.PaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<PaperEntity,Integer> {
    List<PaperEntity> findAllByUserId(Integer userId);
}
