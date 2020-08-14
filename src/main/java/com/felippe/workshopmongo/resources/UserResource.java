package com.felippe.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felippe.workshopmongo.domain.User;
import com.felippe.workshopmongo.dto.UserDTO;
import com.felippe.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") // endpoint
public class UserResource {

	/*
	 * Resource é uma analógia ao Controller
	 */

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // pode-se usar @GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

}
