package com.example.analyticsteam.repository;

import com.example.analyticsteam.entity.ContentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentStatusRepository extends MongoRepository<ContentStatus,String> {
}
