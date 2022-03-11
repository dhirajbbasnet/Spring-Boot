package com.dhiraj.controller.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data

//this will make sure that the data when sent through web service is sent in XML format, only for individual objects
@XmlRootElement
public class MovieDTO {
	
	private int id;
	private String name;
	private int year;
	private String director;
	private String poster;
	private String story;
}
