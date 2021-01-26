package com.example.analyticservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {
    @Id
    String userId;
    int popularity;
    int views;
    int followersPb;
    int followersQuora;
    int categories[];

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getFollowersPb() {
        return followersPb;
    }

    public void setFollowersPb(int followersPb) {
        this.followersPb = followersPb;
    }

    public int getFollowersQuora() {
        return followersQuora;
    }

    public void setFollowersQuora(int followersQuora) {
        this.followersQuora = followersQuora;
    }


    public int[] getCategories() {
        return categories;
    }

    public void setCategories(int[] categories) {
        this.categories = categories;
    }
}
