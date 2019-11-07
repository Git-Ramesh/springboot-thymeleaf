package com.rs.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rs.app.model.User;
import com.rs.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String addUserGet(@ModelAttribute("user") User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String addUserPost(@ModelAttribute("user") @Valid User newUser, BindingResult result) {
		System.out.println(newUser);
//		User existing = userService.getUser(newUser.getId());
//		if(existing != null) {
//			result.rejectValue("id", null, "There is already a registration with that id");
//		}
		if(result.hasErrors()) {
				return "register";
		}
		userService.addUser(newUser);
		return "redirect:/user/register?success";
	}

	@GetMapping("/all")
	public String getUsers(Map<String, Object> model) {
		model.put("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/{id}")
	public void getUser(@PathVariable Long id, Map<String, Object> model) {
		model.put("user", userService.getUser(id));
	}

	@PutMapping
	public void updateUser(User modifiedUser, Map<String, Object> model) {
		User user = userService.updateUser(modifiedUser);
		model.put("user", user);
	}

	@DeleteMapping("/{id}")
	public void deleteMapping(@PathVariable("id") Long id) {
		userService.removeUser(id);
	}

	@DeleteMapping
	public void deleteMapping(User user) {
		userService.removeUser(user);
	}
	
	@ModelAttribute("countries")
	public List<String> getCountries() {
		return Arrays.asList("India", "China", "Japan", "Rushya", "America", "South Coria", "Iran", "Irland");
	}
	
	@ModelAttribute("languages")
	public List<String> getLanguages() {
		return Arrays.asList("English", "Telugu", "Hindi");
	}
}
