package com.dhiraj.controller.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
public class LoginDTO {

	private int id;
	private String username;
	private String password;
	
}
