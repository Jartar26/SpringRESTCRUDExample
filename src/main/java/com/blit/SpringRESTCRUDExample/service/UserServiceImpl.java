package com.blit.SpringRESTCRUDExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.blit.SpringRESTCRUDExample.dao.UserRepository;
import com.blit.SpringRESTCRUDExample.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		userRepo.findById(user.getUserId()).orElseThrow();
		userRepo.save(user);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).get();
		
	}

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		
		try {
		      userRepo.deleteById(userId);  
		    }catch(DataAccessException ex){
		      throw new RuntimeException(ex.getMessage());
		    }
		
	}
	
	

}
