package com.tobeto.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.core.entities.User;
import com.tobeto.core.utilities.results.ErrorDataResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    
	
	private  UserService userService;
    
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		
		return ResponseEntity.ok( this.userService.add(user));
	}
	
	
	//typeof .nette
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError :  exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors, "Dogrulama Hatalari");
		return errors;
	} 
	
}




//200.get  300. 400. 500