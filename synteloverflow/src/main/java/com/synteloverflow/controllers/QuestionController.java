package com.synteloverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {
	
	@RequestMapping("/question")
	public String createQuestion() {
		return "newQuestion";
	}
	

}
