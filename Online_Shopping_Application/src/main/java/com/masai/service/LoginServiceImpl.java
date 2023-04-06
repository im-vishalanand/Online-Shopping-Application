package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.UserDTO;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LogInService {

	@Autowired
	private CustomerRepo uRepo;

	@Autowired
	private CurrentUserSessionRepo currRepo;


	@Override
	public CurrentUserSession getSessionByUuid(String uuid) {
		CurrentUserSession curr = currRepo.findByUuid(uuid);
		return curr;
	}

	@Override
	public CurrentUserSession loginUser(UserDTO dto) throws UserException {

		Customer existingUser = uRepo.findByEmail(dto.getEmail());

		if (existingUser == null) {
			throw new UserException("Please Enter a valid email Id");
		}

		Optional<CurrentUserSession> validUserSesssionOpt = currRepo.findById(existingUser.getCustomerId());

		if (validUserSesssionOpt.isPresent()) {
			throw new UserException("User Already Logged In with this email Id");
		}
		if (existingUser.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);

			CurrentUserSession currentUserSession = new CurrentUserSession();
			currentUserSession.setUserId(existingUser.getCustomerId());
			currentUserSession.setRole(existingUser.getRole());
			currentUserSession.setCartId(existingUser.getCart().getCartId());
			currentUserSession.setUuid(key);

			currentUserSession = currRepo.save(currentUserSession);
			return currentUserSession;

		} else {
			throw new UserException("Please Enter a Valid Password");
		}
	}


	@Override
	public String signOutUser(String key) throws UserException {

		CurrentUserSession validUserSession = currRepo.findByUuid(key);

		if (validUserSession == null) {
			throw new UserException("User Not Logged In with this email Id");
		}
		currRepo.delete(validUserSession);
		return "Sign Out Successfully";
	}

}
