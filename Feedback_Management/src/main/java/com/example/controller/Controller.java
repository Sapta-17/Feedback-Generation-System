package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Feedback;
import com.example.service.FeedbackService;

@RestController
@RequestMapping("/")
public class Controller {
	@Autowired
	private FeedbackService feedbackService;
	
	
	@GetMapping("/")
	public List<Feedback> getAllFeedbacks(){
		return feedbackService.getAllFeedbacks();
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedbackById(@PathVariable("id") int id) {
		return feedbackService.getFeedbackById(id);
	}
	
	@PostMapping
	public Feedback createFeedback(@RequestBody Feedback f) {
		return feedbackService.createFeedback(f);
	}
	
	@PutMapping("/{id}")
	public Feedback updateFeedback(@PathVariable("id") int id,@RequestBody Feedback details) {
		return feedbackService.updateFeedback(id, details);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteFeedback(@PathVariable("id") int id) {
		return feedbackService.deleteFeedback(id);
	}
	
	@GetMapping("/byEmail")
	public List<Feedback> getFeedbackByEmail(@RequestParam("feedbackEmail") String email){
		return feedbackService.getFeedbackByEmail(email);
	}
	
	@GetMapping("/byNature")
	public List<Feedback> getFeedbackByNature(@RequestParam("feedbackNature") boolean nature){
		return feedbackService.getFeedbackByNature(nature);
	}
	
	
	
	
}
