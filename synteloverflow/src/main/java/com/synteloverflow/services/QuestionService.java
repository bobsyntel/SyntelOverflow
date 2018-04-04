package com.synteloverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.synteloverflow.models.Question;
import com.synteloverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository qRepo;
	
	public QuestionService() {}
	
	public QuestionService(QuestionRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	public void addQuestion(Question question) {
		qRepo.save(question);
	}
	
	public List<Question> allQuestions(){
		return qRepo.findAll();
	}
	
	public Optional<Question> getQuestion(Long id) {
		return  qRepo.findById(id);
	  }
	

}
