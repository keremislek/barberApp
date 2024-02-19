package com.example.barbersApp.request;

import lombok.Data;

@Data
public class UserCreateRequest {
	private String eMail;
	private String password;
	private int roleType;
}
