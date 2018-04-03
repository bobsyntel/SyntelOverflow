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
@Table(name="Comment")
public class Comment {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String content;
private String comment_type;
private Long comment_type_id;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="users_id")
private User user;

public Comment() {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getComment_type() {
	return comment_type;
}

public void setComment_type(String comment_type) {
	this.comment_type = comment_type;
}

public Long getComment_type_id() {
	return comment_type_id;
}

public void setComment_type_id(Long comment_type_id) {
	this.comment_type_id = comment_type_id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}



}
