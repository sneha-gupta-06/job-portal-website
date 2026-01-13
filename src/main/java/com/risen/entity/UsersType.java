package com.risen.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;
	
	private String userTypeName;
	
	@OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
	private List<Users> users;
	
}
