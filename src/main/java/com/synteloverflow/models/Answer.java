package com.synteloverflow.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int accepted_answer;
	private String content; 
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	private Question question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	private User user;

	public Answer() {}

	public int getAccepted_answer() {
		return accepted_answer;
	}

	public void setAccepted_answer(int accepted_answer) {
		this.accepted_answer = accepted_answer;
	}

	public Long getId() {
		return id;
	}  
	
	public void setId(Long id) {
		  this.id = id;
	}
	 
	public Question getQuestion() {
		   return question;
	}
	
	public void setQuestion(Question question) {
		   this.question = question;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
