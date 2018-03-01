package com.sb.crud.app.services;

import java.util.List;

import com.sb.crud.app.entity.UserEntity;
import com.sb.crud.app.model.User;

public interface UserService {
	
	boolean addUser(UserEntity user);
	
	void updateUser(UserEntity user);
	
	void deleteUser(UserEntity user);
	
	UserEntity findByUserId(Long id);
	
	void deleteUser(Long id);
	
	List<UserEntity> getAllUser();

}
