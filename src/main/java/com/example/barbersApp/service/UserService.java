package com.example.barbersApp.service;



import com.example.barbersApp.entities.User;
import com.example.barbersApp.request.LoginRequest;
import com.example.barbersApp.request.UserCreateRequest;
import com.example.barbersApp.response.CreateUserResponse;
import com.example.barbersApp.response.LoginResponse;


public interface UserService {

	

	LoginResponse loginUser(LoginRequest request);
	CreateUserResponse addUser(UserCreateRequest request);
	boolean isUserFirstTimeLogin(String email);
	User getUserByEmail(String email);


	
}
