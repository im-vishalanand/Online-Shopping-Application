package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentSession;
import com.masai.model.User;
import com.masai.repository.CurrentSessionDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;

	@Override
	public User createUser(User user) throws UserException {

		Optional<User> existingUser=userDao.findById(user.getId());
		
		if(existingUser!=null) {
			
			throw new UserException("User already registerd with the fiven id");
			
		}
		
		return userDao.save(user);
	}

	@Override
	public User updateCustomer(User user, String key) throws UserException {
		
		CurrentSession loggegUser= currentSessionDao.findByUuid(key);
		
		if(loggegUser==null) {
			
			throw new UserException("Please provide a valid key to update the user");
			
		}
		
		if(user.getId()==loggegUser.getUserId().toString()) {
			
			return userDao.save(user);
			
		}
		else {
			
			throw new UserException("Invalid User Details. login first");
			
		}
		
	}
}
