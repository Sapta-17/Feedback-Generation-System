package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FeedbackService {
	private List<Feedback> feedbackList=new ArrayList<>();
	
	// Fetching all feedbacks
	public List<Feedback> getAllFeedbacks(){
		return feedbackList;
	}
	
	// Fetch feedback by id
	public Feedback getFeedbackById(int id) {
		for(Feedback f:feedbackList) {
			if(f.getId()==id) {
				return f;
			}
		}
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");
	}
	// Create feedback
	public Feedback createFeedback(Feedback f) {
		feedbackList.add(f);
		return f;
	}
	
	//Update feedback
	public Feedback updateFeedback(int id,Feedback details) {
		for(Feedback f:feedbackList) {
			if(f.getId()==id) {
				f.setFeedbackProductName(details.getFeedbackProductName());
				f.setFeedbackContents(details.getFeedbackContents());
				f.setFeedbackNature(details.isFeedbackNature());
				f.setFeedbackEmail(details.getFeedbackEmail());
				return f;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");
	}
	// Delete feedback
	public boolean deleteFeedback(int id) {
		return feedbackList.removeIf(f ->f.getId()==id);
	}
	
	// fetch feedback by email
	public List<Feedback> getFeedbackByEmail(String email){
		List<Feedback> feedbacks= new ArrayList<>(); 
		for(Feedback f:feedbackList) {
			if(f.getFeedbackEmail().equals(email)) {
				feedbacks.add(f);
			}
		}
		return feedbacks;
	}
	// fetch feedback by nature
	public List<Feedback> getFeedbackByNature(boolean nature){
		List<Feedback> feedbacks=new ArrayList<>();
		for(Feedback f:feedbackList) {
			if(f.isFeedbackNature()==nature) {
				feedbacks.add(f);
			}
		}
		return feedbacks;
	}
	
	
	
}
