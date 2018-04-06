package com.synteloverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.synteloverflow.models.Answer;
import com.synteloverflow.repositories.AnswerRepository;



@Service
public class AnswerService {
   private  AnswerRepository answerRepo;
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public void createAnswer(Answer answer) {
		answerRepo.save(answer);
	}
	
	public List<Answer> allAnswers(){
		return answerRepo.findAll();
	}
}
