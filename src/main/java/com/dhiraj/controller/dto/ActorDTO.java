package com.dhiraj.controller.dto;

import java.sql.Timestamp;


import com.dhiraj.dao.entity.MovieEntity;

import lombok.Data;

@Data
public class ActorDTO {


	private int id;
	private String name;
	private String photo;
	private String role;
	private Timestamp createDate;
	
	private int mid;
	
}
