package com.example.analyticservice.repository;

import com.example.analyticservice.entity.ContentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentStatusRepository extends MongoRepository<ContentStatus,String> {
}
