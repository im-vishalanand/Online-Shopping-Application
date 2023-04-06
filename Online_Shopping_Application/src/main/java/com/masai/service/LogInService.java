package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.UserDTO;

public interface LogInService {

	public CurrentUserSession getSessionByUuid(String uuid);

	public CurrentUserSession loginUser(UserDTO dto) throws UserException;

	public String signOutUser(String key) throws UserException;
}
