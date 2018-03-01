package com.sb.crud.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.crud.app.dao.UserDAO;
import com.sb.crud.app.entity.UserEntity;
import com.sb.crud.app.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean addUser(UserEntity user) {
		
		boolean flag=false;
		//UserEntity entity=copyProperties(user);
		UserEntity entity= userDAO.addUser(user);
		
		if(entity!=null){
			flag=true;
		}
		
		return flag;
	}

	@Override
	public void updateUser(UserEntity user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(UserEntity user) {
		userDAO.deleteUser(user);
	}

	@Override
	public UserEntity findByUserId(Long id) {		
		
		return userDAO.findByUserId(id);
	}

	@Override
	public void deleteUser(Long id) {
		userDAO.deleteUser(id);
		
	}

	@Override
	public List<UserEntity> getAllUser() {
		
				
		return userDAO.getAllUser();
	}
	
	private UserEntity copyProperties(User user){		
		UserEntity entity=new UserEntity();
		entity.setId(user.getId());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());		
	return entity;	
	}
	private User copyProperties(UserEntity entity){		
		User user=new User();
		user.setId(entity.getId());
		user.setUserName(entity.getUserName());
		user.setAge(entity.getAge());		
	return user;	
	}

}
