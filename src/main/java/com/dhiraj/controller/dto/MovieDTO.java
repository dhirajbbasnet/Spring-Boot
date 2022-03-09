package com.dhiraj.controller.dto;

import lombok.Data;

@Data
public class MovieDTO {
	
	private int id;
	private String name;
	private int year;
	private String director;
	private String poster;
	private String story;
}
