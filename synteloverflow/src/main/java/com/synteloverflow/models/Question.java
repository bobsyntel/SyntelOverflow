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
@Table(name="question")
public class Question {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String title;
private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	private User user;
	
public Question () {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

}
