package com.example.barbersApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.barbersApp.request.LoginRequest;
import com.example.barbersApp.request.UserCreateRequest;
import com.example.barbersApp.response.CreateUserResponse;
import com.example.barbersApp.response.LoginResponse;
import com.example.barbersApp.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/save")
	public CreateUserResponse saveUser(@RequestBody UserCreateRequest request) {
		CreateUserResponse response=new CreateUserResponse();
		response=userService.addUser(request);
		
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request){
		LoginResponse loginResponse=userService.loginUser(request);
		
		return ResponseEntity.ok(loginResponse);
	}
}
