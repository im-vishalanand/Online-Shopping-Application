package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.CurrentSessionDao;
import com.masai.repository.CustomerDao;

import net.bytebuddy.utility.RandomString;




@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CurrentSessionDao cudao;
	
	@Autowired
	private CustomerDao custdao;
	
	
	@Override
	public String login(LoginDTO dto) throws LoginException {
		
		
		Customer existingCustomer= custdao.findByEmail(dto.getEmail());
		
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid Email ");
			
			 
		}
		
		
		
		
		Optional<CurrentSession> validCustomerSessionOpt =  cudao.findById(existingCustomer.getCustomerId());
		
		
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this Email");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			CurrentSession currentSession = new CurrentSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			cudao.save(currentSession);

			return currentSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	
	
	}

	
	
	
	
	
	
	
//	@Override
//	public String login(LoginDTO dto) throws LoginException {
//		
//		// admin and Customer check
//		
//		Admin a = admindao.findByUsername(dto.getUsername());
//		
//		Customer c = custdao.findByEmail(dto.getUsername());
//		
//		// admin loging check
//		
//		if(c == null && a!=null) {
//		
//		Optional<CurrentSession> existAdmin = cudao.findById(a.getAdminId());
//		
//		if(existAdmin.isPresent()) throw new LoginException("already loggedIn");
//		
//		if(a.getPassword().equals(dto.getPassword())) {
//			String key = "6";
//			CurrentSession newUser = new CurrentSession();
//			
//		newUser.setLocalDateTime(LocalDateTime.now());
//		newUser.setType(true);
//		newUser.setUuid(key);
//		newUser.setUserId(a.getAdminId());
//		cudao.save(newUser);
//		return newUser.toString();
//		}
//		else
//			throw new LoginException("Please enter a vaild password");
//	}
//		
//		//Customer login check
//		
//		else if(a== null && c!=null ) {
//			Optional<CurrentSession> cu = cudao.findById(c.getCustomerId());
//			if(cu.isPresent()) {
//				throw new LoginException("Already loggedIn");
//			}
//			
//			if(c.getPassword().equals(dto.getPassword())) {
//				String key = "6";
//				CurrentSession newUser = new CurrentSession();
//				newUser.setLocalDateTime(LocalDateTime.now());
//				newUser.setType(true);
//				newUser.setUuid(key);
//				newUser.setUserId(c.getCustomerId());
//				cudao.save(newUser);
//				return newUser.toString();
//				
//			}
//			else
//				throw new LoginException("Please enter a vaild password");
//		}
//		else {
//			
//				throw new LoginException("Please enter a vaild username");
//		}
//		
//	}

	@Override
	public String logout(String key) throws LoginException {
		CurrentSession cu = cudao.findByUuid(key);
		
		if(cu == null) throw new LoginException("User not loggedin with this username");
		
		cudao.delete(cu);
		
		return "Logged Out";
	}



}
