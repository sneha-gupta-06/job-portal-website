package com.risen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risen.entity.Users;

public interface UsersRepository  extends JpaRepository<Users, Integer>{

}
