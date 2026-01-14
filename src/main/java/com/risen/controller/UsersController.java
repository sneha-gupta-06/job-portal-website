package com.risen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.risen.entity.Users;
import com.risen.entity.UsersType;
import com.risen.service.UsersService;
import com.risen.service.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {
	
	@Autowired
	private UsersTypeService usersTypeService;
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/register")
	public String register(Model model) {
		
		List<UsersType> usersType = usersTypeService.getAll();
		
		model.addAttribute("getAllTypes", usersType);
		model.addAttribute("user", new Users());
		
		return "register";
	}
	
	@PostMapping("/register/new")
	public String userRegistration(@Valid Users users, Model model) {
		System.out.println("users: " + users);
		
		Optional<Users> userByEmail = usersService.getUserByEmail(users.getEmail());
		
		
		if (userByEmail.isPresent()) {
			
			model.addAttribute("error", "Email already existed, Ty with different email");
			List<UsersType> usersType = usersTypeService.getAll();
			
			model.addAttribute("getAllTypes", usersType);
			model.addAttribute("user", new Users());
			
			return "register";
		}
		
		usersService.addNew(users);
		return "dashboard";
	}

}
