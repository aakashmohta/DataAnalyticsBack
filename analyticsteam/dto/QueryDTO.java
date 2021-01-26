package com.example.analyticsteam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDTO {
    int channel_id;
    String userId;
    String category;
    List<String> registeredCategories;
    String type;
    String typeId;
    String action;
    LocalDateTime time;
    int usersRegistered;
    String winnerId;
    String mostAnsQ;
    int noOfQCrawled;
    int noOfQScreened;
    int noOfQPerCategory[];

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getRegisteredCategories() {
        return registeredCategories;
    }

    public void setRegisteredCategories(List<String> registeredCategories) {
        this.registeredCategories = registeredCategories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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

    public int getNoOfQCrawled() {
        return noOfQCrawled;
    }

    public void setNoOfQCrawled(int noOfQCrawled) {
        this.noOfQCrawled = noOfQCrawled;
    }

    public int getNoOfQScreened() {
        return noOfQScreened;
    }

    public void setNoOfQScreened(int noOfQScreened) {
        this.noOfQScreened = noOfQScreened;
    }

    public int[] getNoOfQPerCategory() {
        return noOfQPerCategory;
    }

    public void setNoOfQPerCategory(int[] noOfQPerCategory) {
        this.noOfQPerCategory = noOfQPerCategory;
    }
}
