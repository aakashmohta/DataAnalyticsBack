package com.example.analyticsteam.repository;

import com.example.analyticsteam.entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}
