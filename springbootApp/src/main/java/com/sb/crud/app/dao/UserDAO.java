package com.sb.crud.app.dao;

import java.util.List;

import com.sb.crud.app.entity.UserEntity;

public interface UserDAO {
	
	UserEntity addUser(UserEntity entity);
	
	void updateUser(UserEntity entity);
	
	void deleteUser(UserEntity entity);
	
	UserEntity findByUserId(Long id);
	
	void deleteUser(Long id);
	
	List<UserEntity> getAllUser();
		

}
