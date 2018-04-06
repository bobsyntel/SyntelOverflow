package com.synteloverflow.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;
@Entity
@Table(name="vote")
public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private static final int value=1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="users_id")
	private User user;
	
	@Any (metaColumn = @Column(name = "vote_type"))
	@AnyMetaDef(idType = "long", metaType = "string",
	metaValues = {
	@MetaValue(targetEntity = Question.class, value = "question"),
	@MetaValue(targetEntity = Answer.class, value = "answer")
	})
	@Cascade( { org.hibernate.annotations.CascadeType.ALL})
	@JoinColumn(name = "vote_type_id")
	
	private ContentType contentType;
	
	public Vote() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getValue() {
		return value;
	}
	
//	public String getVote_type() {
//		return vote_type;
//	}
//	
//	public void setVote_type(String vote_type) {
//		this.vote_type = vote_type;
//	}
//	
//	public int getVote_type_id() {
//		return vote_type_id;
//	}
//	
//	public void setVote_type_id(int vote_type_id) {
//		this.vote_type_id = vote_type_id;
//	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
