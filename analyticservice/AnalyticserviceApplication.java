package com.example.analyticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AnalyticserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticserviceApplication.class, args);
	}

}
