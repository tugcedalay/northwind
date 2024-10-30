package com.tobeto.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.core.entities.User;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    
	
	private  UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody User user) {
		return ResponseEntity.ok( this.userService.add(user));
	}
}




//200.get  300. 400. 500