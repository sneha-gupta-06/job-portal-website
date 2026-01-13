package com.risen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risen.entity.UsersType;
import com.risen.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	@Autowired
	private UsersTypeRepository usersTypeRepository;
	
	public List<UsersType> getAll(){
		return usersTypeRepository.findAll();
	}
}
