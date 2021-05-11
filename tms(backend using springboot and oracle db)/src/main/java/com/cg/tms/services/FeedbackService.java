package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Feedback;
import com.cg.tms.repositories.IFeedbackRepository;

/**
 * 
 * Class to implement CRUD operations from IFeedbackRepository
 * 
 */
@Service
public class FeedbackService {

	@Autowired
	private IFeedbackRepository feedbackRepository;

	/**
	 * 
	 * @param feedback of Feedback type
	 */
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	/**
	 * 
	 * @return List of all Feedback
	 */
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	/**
	 * @param id of integer type
	 * 
	 */
	public String delete(int id) {
		Feedback feedback = feedbackRepository.findById(id).orElseThrow(NullPointerException::new);
		feedbackRepository.deleteById(feedback.getId());
		return "Feedback with id: " + id + " deleted!!";

	}

	public Feedback getFeedbackById(int id) {
		return feedbackRepository.findById(id).orElseThrow(NullPointerException::new);
	}
}