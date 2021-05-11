package com.cg.tms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.tms.entities.Feedback;
import com.cg.tms.services.FeedbackService;

/**
 * 
 * Controller class for testing FeedbackService
 *
 */
@RestController
@CrossOrigin("*")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/addfeedbaack")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
		return new ResponseEntity<>(feedbackService.addFeedback(feedback), HttpStatus.OK);
	}

	@GetMapping("/getfeedbacks")
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}

	@DeleteMapping("/deletefeedbackbyid/{id}")
	public String deleteFeedback(@PathVariable int id) {
		return feedbackService.delete(id);
	}

	@GetMapping("/getfeedbackbyid/{id}")
	public ResponseEntity<Feedback> getAllFeedback(@PathVariable int id) {
		return new ResponseEntity<>(feedbackService.getFeedbackById(id), HttpStatus.OK);
	}
}