package com.dhiraj.controller.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//creating this just to return after deleting 

@Data
@XmlRootElement
public class ApplicationResponseDTO {
	
	private String code;
	private String message;
	
	
}
