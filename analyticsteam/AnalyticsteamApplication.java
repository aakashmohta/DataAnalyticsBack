package com.example.analyticsteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AnalyticsteamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsteamApplication.class, args);
	}

}
