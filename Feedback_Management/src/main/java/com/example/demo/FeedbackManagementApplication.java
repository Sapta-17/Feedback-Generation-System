package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.Feedback;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller", "com.example.service"})
public class FeedbackManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackManagementApplication.class, args);
		Feedback f1=new Feedback(1,"TV","The quality is good",true,"xyz@gamil.com");
		Feedback f2=new Feedback(2,"AC","The quality is good",false,"xyz1@gamil.com");
		List<Feedback>fl=new ArrayList<>();
		fl.add(f1);
		fl.add(f2);
		for(Feedback f:fl) {
			System.out.println(f.getId());
			System.out.println(f.getFeedbackContents());
			System.out.println(f.getFeedbackProductName());
			System.out.println(f.getFeedbackEmail());
			System.out.println(f.isFeedbackNature());
		}
	}

}
