package com.cg.tms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.tms.entities.Feedback;
import com.cg.tms.repositories.IFeedbackRepository;
import com.cg.tms.services.FeedbackService;

@SpringBootTest
 class FeedbackServiceTest {

	@MockBean
	private IFeedbackRepository feedbackRepository;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Test
	void testAddFeedBack() {
		Feedback f = new Feedback();
		f.setId(1);
		when(feedbackRepository.save(f)).thenReturn(f);
		assertEquals(f, feedbackService.addFeedback(f));
	}

	@Test
	void testNotAddCategory() {
		Feedback f1 = new Feedback();
		f1.setId(1);
		Feedback f2 = new Feedback();
		f2.setId(2);
		when(feedbackRepository.save(f1)).thenReturn(f1);
		assertNotEquals(f1, feedbackService.addFeedback(f2));
	}
	
	@Test
	void testGetAllFeedback() {
		List<Feedback>list = new ArrayList<>();
		Feedback f1 = new Feedback();
		f1.setId(1);
		Feedback f2 = new Feedback();
		f2.setId(2);
		list.add(f1);
		list.add(f2);
		when(feedbackRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), feedbackService.getAllFeedback().size());
	}
	
	@Test
	void testNotGetAllCategory() {
		List<Feedback>list = new ArrayList<>();
		Feedback f1 = new Feedback();
		f1.setId(1);
		Feedback f2 = new Feedback();
		f2.setId(2);
		list.add(f1);
		list.add(f2);
		when(feedbackRepository.findAll()).thenReturn(list);
		assertNotEquals(3, feedbackService.getAllFeedback().size());
	}
	
	@Test
	void testDelete() {
		Feedback f = new Feedback();
		f.setId(1);
		doNothing().when(feedbackRepository).deleteById(1);
		when(feedbackRepository.findById(1)).thenReturn(Optional.of(f));
		assertEquals("Feedback with id: "+f.getId()+" deleted!!", feedbackService.delete(1));
	}
	
	@Test
	void testNotDelete() {
		Feedback f = new Feedback();
		f.setId(1);
		doNothing().when(feedbackRepository).deleteById(1);
		when(feedbackRepository.findById(1)).thenReturn(Optional.of(f));
		Assertions.assertThrows(NullPointerException.class, ()-> feedbackService.delete(3));
	}
	
	@Test
	void getCategoryById() {
		Feedback expected = new Feedback();
		expected.setId(1);
		when(feedbackRepository.findById(1)).thenReturn(Optional.of(expected));
		Feedback actual = feedbackService.getFeedbackById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotCategoryById() {
		Feedback expected = new Feedback();
		expected.setId(1);
		when(feedbackRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(NullPointerException.class,()->feedbackService.getFeedbackById(4));
	}
}