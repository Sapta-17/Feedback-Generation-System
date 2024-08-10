package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Feedback {
	private int id;
	private String feedbackProductName;
	private String feedbackContents;
	private boolean feedbackNature;
	private String feedbackEmail;
	
}
