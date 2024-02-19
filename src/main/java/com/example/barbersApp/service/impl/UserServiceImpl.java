package com.example.barbersApp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.barbersApp.entities.User;
import com.example.barbersApp.repository.UserRepository;
import com.example.barbersApp.request.LoginRequest;
import com.example.barbersApp.request.UserCreateRequest;
import com.example.barbersApp.response.CreateUserResponse;
import com.example.barbersApp.response.LoginResponse;
import com.example.barbersApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@Override
	public CreateUserResponse addUser(UserCreateRequest request) {
		User user= new User();
		
		user.setEMail(request.getEMail());
		user.setRoleType(request.getRoleType());
		user.setPassword(this.passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		
		return new CreateUserResponse("Succes",true);
		}

	@Override
	public LoginResponse loginUser(LoginRequest request) {
		User user=userRepository.findByeMail(request.getEmail());
		if(user!=null) {
			String password=request.getPassword();
			String encodePassword=user.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodePassword);
			
			if(isPwdRight) {
			
				return new LoginResponse("Login succes",true);
			}else {
				return new LoginResponse("pasword wrong",false);
			}
		}else {
			return new LoginResponse("email wrong",false);
		}
		
	
	}

	@Override
	public boolean isUserFirstTimeLogin(String email) {
		User user=userRepository.findByeMail(email);
		
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByeMail(email);
	}

}
