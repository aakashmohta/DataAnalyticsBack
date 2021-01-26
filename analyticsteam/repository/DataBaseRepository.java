package com.example.analyticsteam.repository;

import com.example.analyticsteam.entity.DataBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRepository extends MongoRepository<DataBase, String> {
}
