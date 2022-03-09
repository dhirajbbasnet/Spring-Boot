package com.dhiraj.dao.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	
	//creating a many to many relationship with the role ENtity
	@ManyToMany(cascade =  CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "id")},
					inverseJoinColumns = {@JoinColumn(name="rid")})
	private Set<RoleEntity> roles;
	
}
