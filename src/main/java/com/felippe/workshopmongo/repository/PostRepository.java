package com.felippe.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felippe.workshopmongo.domain.Post;
import com.felippe.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	

}
