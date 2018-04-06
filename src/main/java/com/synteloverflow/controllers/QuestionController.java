package com.synteloverflow.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synteloverflow.models.Answer;
import com.synteloverflow.models.Question;
import com.synteloverflow.models.Tag;
import com.synteloverflow.services.QuestionService;
import com.synteloverflow.services.TagService;
import com.synteloverflow.services.UserService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private UserService userServ;
	
//	public QuestionController(QuestionService qService,TagService tagServ) {
	//	this.qService = qService;
		//this.tagServ = tagServ;
	//}
	
	    	
	@RequestMapping("/questions/new/{id}")
	public String newQuestion(@PathVariable("id") Long id,@ModelAttribute("newQuestion") Question question,Principal principal,Model model) {
		String user =  principal.getName();
		System.out.println("in question "+user);
		model.addAttribute("user", user);
		model.addAttribute("userId", id);
		return "questions/newQuestion";
	}
	
	@PostMapping("/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question,BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result);
			System.out.println("errros abound");
			return "questions/newQuestion";
		}else {
	        qService.addQuestion(question);
	        question.getId();
	        System.out.println("No errors");
	        
	        String qId = String.valueOf(question.getId());
	        return "redirect:/questions/".concat(qId);
		}
		
	}
	@RequestMapping("/questions/{id}")
	public String Show(@PathVariable("id") Long id,Model model,@ModelAttribute("Amodel") Answer answer) {
		model.addAttribute("question", qService.getQuestion(id));
		model.addAttribute("userId", qService.getQuestion(id).getUser());
		return "questions/show";
	}
	

}
