package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.UserDTO;
import com.masai.service.LogInService;

import jakarta.validation.Valid;

@RestController
public class LogInLogOutController {

	@Autowired
	private LogInService logService;

	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInHandler(@Valid @RequestBody UserDTO dto) throws UserException {
		CurrentUserSession result = logService.loginUser(dto);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logoutuserHandler(@RequestParam String uuid) throws UserException {

		String log = logService.signOutUser(uuid);

		return new ResponseEntity<>(log, HttpStatus.OK);
	}

}
