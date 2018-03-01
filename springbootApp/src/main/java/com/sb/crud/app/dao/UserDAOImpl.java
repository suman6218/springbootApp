package com.sb.crud.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.crud.app.entity.UserEntity;
import com.sb.crud.app.repo.UserRepository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity entity) {
		return userRepository.save(entity);
	}

	@Override
	public void updateUser(UserEntity entity) {
		
		UserEntity user=userRepository.findOne(entity.getId());
		user.setUserName(entity.getUserName());
		user.setAge(entity.getAge());
		
	}

	@Override
	public void deleteUser(UserEntity entity) {
		
	}

	@Override
	public UserEntity findByUserId(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public List<UserEntity> getAllUser() {
	
	List<UserEntity> users=new ArrayList<UserEntity>();
	Iterable<UserEntity> userList=	userRepository.findAll();
	for(UserEntity user:userList){
		users.add(user);
	}
		return users;
	}

}
