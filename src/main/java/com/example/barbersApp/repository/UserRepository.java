package com.example.barbersApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.barbersApp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByeMail(String email);
	
	
}
