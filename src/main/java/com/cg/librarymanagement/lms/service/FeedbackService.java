package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.FeedbackDao;
import com.cg.librarymanagement.lms.dtos.Feedback;
import com.cg.librarymanagement.lms.dtos.User;
import com.cg.librarymanagement.lms.exception.FeedbackNotFoundException;
import com.cg.librarymanagement.lms.exception.UserNotFoundException;





@Service
public class FeedbackService {
	@Autowired
	private FeedbackDao feedbackdao;
	
	public Feedback writeFeedback(Feedback feedback) {
		System.out.println("Book added.");
		return feedbackdao.save(feedback);

	}
		
	public Feedback updateFeedback(int id,Feedback feedback) {
		System.out.println("feedback updated.");
		try {
		Optional<Feedback> repfeedback = feedbackdao.findById(id);
		if (!repfeedback.isPresent()) {
			throw new FeedbackNotFoundException("feedback not found for id"+id);
		}
		else
		{
			Feedback feedbackToBeUpdated = repfeedback.get();

			feedbackToBeUpdated.setFeedbackDate(feedback.getFeedbackDate());
			feedbackToBeUpdated.setDescription(feedback.getDescription());
			feedbackToBeUpdated.setRating(feedback.getRating());
			feedbackToBeUpdated.setComments(feedback.getComments());
			return feedbackdao.save(feedbackToBeUpdated);

		}
		}
		catch(FeedbackNotFoundException e)
		{
			System.err.println(e);
		}
		return null;
	}
	
	public List<Feedback> viewFeedbackList() {
		System.out.println("FEEDBACK...");
		return feedbackdao.findAll();
	}
	
	//wrong code have to update it
	public Feedback viewFeedBackByUser(String username)
	{
		System.out.println("feedback");
		
			List<Feedback> optional = feedbackdao.findAll();
			for(Feedback u:optional)
			{
				
					if(u.getUsername().equals(username))
					{
						return u;
					}
			
	        return null;
	}
	}
}


