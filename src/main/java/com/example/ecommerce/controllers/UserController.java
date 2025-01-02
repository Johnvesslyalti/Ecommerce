package com.example.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.services.UserService;

@RestController
@RequestMapping("/users/")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("view")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@PostMapping("register")
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "User added sucessfully";
	}
	@DeleteMapping("delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "User Deleted Successfully";
	}
}
