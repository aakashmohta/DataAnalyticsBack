package com.example.analyticservice.service;

import com.example.analyticservice.entity.ContentStatus;
import com.example.analyticservice.repository.ContentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentStatusService {
    @Autowired
    ContentStatusRepository contentStatusRepository;

    public ContentStatus save(ContentStatus contentStatus){
        return contentStatusRepository.save(contentStatus);
    }

    public List<ContentStatus> findAll(){
        return contentStatusRepository.findAll();
    }

//    public List<ContentStatus> questionByCategory(){
//
//    }
}
