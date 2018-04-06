package com.synteloverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synteloverflow.models.Answer;
import com.synteloverflow.services.AnswerService;


@Controller
public class Answers {
	private AnswerService AnswerServ;
	public Answers(AnswerService answerServ) {
		
		AnswerServ = answerServ;
	}
	@RequestMapping(method=RequestMethod.POST, value="/answer/create")
	public String Create(@Valid @ModelAttribute("Amodel") Answer answer ,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			System.out.println("in errors");
			System.out.println(result);
			return "questions/show";
		}else {
			System.out.println("in answers");
			
			AnswerServ.createAnswer(answer);
			System.out.println(answer.getId());
			 String qId = String.valueOf(answer.getQuestion().getId());
			return "redirect:/questions/".concat(qId);
		}
	}

}
