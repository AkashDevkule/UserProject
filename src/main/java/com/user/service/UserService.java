package com.user.service;

import com.user.dto.UserDTO;
import com.user.exception.UserException;

public interface UserService {

	//create user
	
	public void createUser(UserDTO userDto) throws UserException;
}
