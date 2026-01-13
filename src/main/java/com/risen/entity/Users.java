package com.risen.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	private String password;
	
	private boolean isActive;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="userTypeId", referencedColumnName = "userTypeId")
	private UsersType userTypeId;
}
