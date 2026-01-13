package com.risen.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risen.entity.Users;
import com.risen.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public Users addNew(Users users) {
			
		users.setActive(true);
		users.setRegistrationDate(LocalDate.now());
		
		return usersRepository.save(users);
	}
}
