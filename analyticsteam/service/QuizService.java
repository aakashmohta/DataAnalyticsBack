package com.example.analyticsteam.service;

import com.example.analyticsteam.dto.TimeDTO;
import com.example.analyticsteam.entity.DataBase;
import com.example.analyticsteam.entity.GraphList;
import com.example.analyticsteam.entity.Quiz;
import com.example.analyticsteam.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    public Quiz save(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public List<GraphList> mostPopularQuiz(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query();
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<Quiz> dataBaseList=mongoTemplate.find(query,Quiz.class);
        for(Quiz dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getQuizId(),dataBase.getUsersRegistered()));
        }
        return graphList;
    }

    public List<GraphList> quizRunning(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query();
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<Quiz> dataBaseList=mongoTemplate.find(query,Quiz.class);
        for(Quiz dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getQuizId(),dataBase.getUsersRegistered()));
        }
        return graphList;
    }
}
