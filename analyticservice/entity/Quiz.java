package com.example.analyticservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("quiz")
public class Quiz {
    String quizId;
    int usersRegistered;
    String winnerId;
    String mostAnsQ;
    LocalDateTime startTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public int getUsersRegistered() {
        return usersRegistered;
    }

    public void setUsersRegistered(int usersRegistered) {
        this.usersRegistered = usersRegistered;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public String getMostAnsQ() {
        return mostAnsQ;
    }

    public void setMostAnsQ(String mostAnsQ) {
        this.mostAnsQ = mostAnsQ;
    }
}
