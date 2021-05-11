package com.cg.tms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.tms.entities.Feedback;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

	public Feedback findFeedbackById(int id);

	public List<Feedback> findByCustomerId(int id);

}