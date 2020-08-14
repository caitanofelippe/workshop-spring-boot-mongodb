package com.felippe.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felippe.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users") // endpoint
public class UserResource {

	/*
	 * Resource é uma analógia ao Controller
	 */

	@RequestMapping(method = RequestMethod.GET) // pode-se usar @GetMapping
	public ResponseEntity<List<User>> findAll() {
		User ana = new User("1", "Ana Julia", "ana@gmail.com");
		User maria = new User("2", "Maria Carolina", "maria@gmail.com");
		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(ana, maria));

		return ResponseEntity.ok().body(list);

	}

}
