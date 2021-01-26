package com.example.analyticservice.repository;

import com.example.analyticservice.entity.DataBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRepository extends MongoRepository<DataBase, String> {
}
