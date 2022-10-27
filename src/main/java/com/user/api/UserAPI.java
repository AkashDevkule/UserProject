package com.user.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.user.dto.UserDTO;
import com.user.exception.UserException;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping(path = "/")
public class UserAPI {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private Environment env;

	@GetMapping("/")
	public void getHomePage() throws UserException {

		System.out.println("<h3> WELCOME TO HOME PAGE</h3>");

	}

	@PostMapping(path = "create")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDto) throws UserException {

		try {
			userServiceImpl.createUser(userDto);
			String createdMessage = env.getProperty("UserAPI.USER_ADDED");
			return new ResponseEntity<>(createdMessage, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, env.getProperty("UserAPI.ID_ALREADY_PRESENT"));
		}
	}
}
