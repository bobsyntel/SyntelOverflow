package com.synteloverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.synteloverflow.models.User;



public interface UserRepository extends CrudRepository<User,Long> {
	User findByUsername(String username);
	//User findById(String username);
}

