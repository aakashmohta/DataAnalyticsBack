package com.example.analyticsteam.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("csr")
public class ContentStatus {
    int noOfQCrawled;
    int noOfQScreened;
    int noOfQPerCategory[];

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
