package com.sb.crud.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.crud.app.entity.UserEntity;
import com.sb.crud.app.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
		
	@Autowired
	UserService userService;	
	
	@GetMapping("add/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id){
		log.debug("*****Start excuting getUser() method******");
		UserEntity user=userService.findByUserId(id);
		log.debug("*****End excuting getUser() method****");
	return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
		log.debug("*****Start excuting addUser() method******");
		userService.addUser(user);	
		log.debug("*****End excuting addUser() method******");
	return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){	
		log.debug("*****Start excuting updateUser() method******");
		userService.updateUser(user);	
		log.debug("*****End excuting updateUser() method******");
	return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){	
		log.debug("*****Start excuting deleteUser() method******");
		userService.deleteUser(id);	
		log.debug("*****Start excuting deleteUser() method******");
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<UserEntity>> getAllUsers(){	
		log.debug("*****Start excuting getAllUsers() method******");
		List<UserEntity> users=userService.getAllUser();
		log.debug("*****Start excuting getAllUsers() method******");
	return new ResponseEntity<List<UserEntity>>(users,HttpStatus.OK);
	}


}
