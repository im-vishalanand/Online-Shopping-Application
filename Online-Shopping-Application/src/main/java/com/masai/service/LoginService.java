package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.model.LoginDTO;

public interface LoginService {
	
	public String login(LoginDTO dto) throws LoginException;
	
	public String logout(String key) throws LoginException;
}
