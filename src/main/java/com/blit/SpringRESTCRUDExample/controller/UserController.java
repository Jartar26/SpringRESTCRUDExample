package com.blit.SpringRESTCRUDExample.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blit.SpringRESTCRUDExample.entity.User;
import com.blit.SpringRESTCRUDExample.service.UserService;


//@Controller+@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//localhost:8080/user/add and pass the user body in json format
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	//localhost:8080/user/getAll
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAllUsers();
	}
	
	//localhost:8080/user/4
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
    //localhost:8080/user/updateUser and pass the user body in json format
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		try
		{
		userService.updateUser(user);
		return new ResponseEntity<String>(HttpStatus.OK);}
		catch(NoSuchElementException e){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//localhost:8080/user/3
	@DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable int id){
	    try {
	      userService.deleteUserById(id);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(RuntimeException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
     }
}
