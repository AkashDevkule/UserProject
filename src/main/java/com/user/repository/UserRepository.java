package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	//access modifier Optional<Table Name> findByColumnName(parameter) 
	
	public Optional<UserEntity> findByUserEmail(String email);
	
	public Optional<UserEntity> findByUserMobNo(Long mobNo); 
}
