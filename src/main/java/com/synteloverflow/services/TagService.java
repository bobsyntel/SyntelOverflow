package com.synteloverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.synteloverflow.models.Tag;
import com.synteloverflow.repositories.TagRepository;



@Service
public class TagService {
  private TagRepository tagRepo;
  
  public TagService(TagRepository tagRepo) {
	  this.tagRepo = tagRepo;
  }
  /*
  public void createTag(Tag tag) {
	  tagRepo.save(tag);
  }
  */
  
   public Tag findOrCreateTag(String element) {
	   System.out.println("IN tagservice "+element);
	 //  Tag checkTag = tagRepo.findBySubject(element);
	  // Tag checkTag = tagRepo.fetchSubject(element);
	   System.out.println("IN tagservice  after "+element);
	 //  if(checkTag == null) { 
		  Tag tag = new Tag();
		  tag.setSubject(element);
		  System.out.println("IN tagservice if  "+element);
		return tagRepo.save(tag);
	  // }else {
		 //  return checkTag;
	  // }
   }
   
}
