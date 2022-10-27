package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDTO;
import com.user.entity.UserEntity;
import com.user.exception.UserException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void createUser(UserDTO userDto) throws UserException {
		
		boolean isIdPresent= userRepo.findById(userDto.getUserId()).isPresent();
		
		if (!isIdPresent && !userRepo.findByUserEmail(userDto.getUserEmail()).isPresent()) {
			if (!userRepo.existsById(userDto.getUserId())) {
				
				UserEntity newUser= new UserEntity();
				newUser.setUserId(userDto.getUserId());
				newUser.setUserName(userDto.getUserName());
				newUser.setUserEmail(userDto.getUserEmail());
				newUser.setUserMobNo(userDto.getUserMobNo());
				
				userRepo.save(newUser);
				System.out.println("Added Successfully: "+newUser.toString());
			}else {
				throw new UserException("UserService.USER_ID_EXITS");
			}
		}else {
			throw new UserException("UserService.USER_ID_OR_EMAIL_ALREADY_PRESENT");
		}
		
	}

}
