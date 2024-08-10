package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Feedback;
import com.example.service.FeedbackService;

@SpringBootTest
class FeedbackManagementApplicationTests {

	@Autowired
    private FeedbackService feedbackService;
	@Test
	void createFeedback() {
		Feedback feedback = new Feedback();
		//feedback.setId(1);
        feedback.setFeedbackProductName("Product 1");
        feedback.setFeedbackContents("Great product!");
        feedback.setFeedbackNature(true);
        feedback.setFeedbackEmail("user@gmail.com");

        Feedback savedFeedback = feedbackService.createFeedback(feedback);

        assertThat(savedFeedback.getId()).isGreaterThan(0);
	}
	@Test
	 void getFeedbackByEmailTest() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackProductName("Product 1");
        feedback.setFeedbackContents("Great product!");
        feedback.setFeedbackNature(true);
        feedback.setFeedbackEmail("user@gmail.com");

        feedbackService.createFeedback(feedback);

        List<Feedback> feedbacks = feedbackService.getFeedbackByEmail("user@example.com");
        assertThat(feedbacks).isNotEmpty();
    }
	@Test
    void getFeedbackByNatureTest() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackProductName("Product 1");
        feedback.setFeedbackContents("Great product!");
        feedback.setFeedbackNature(true);
        feedback.setFeedbackEmail("user@gmail.com");

        feedbackService.createFeedback(feedback);

        List<Feedback> feedbacks = feedbackService.getFeedbackByNature(true);
        assertThat(feedbacks).isNotEmpty();
    }
	

}

