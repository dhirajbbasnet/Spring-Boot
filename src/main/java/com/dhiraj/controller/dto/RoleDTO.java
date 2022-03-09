package com.dhiraj.controller.dto;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
public class RoleDTO {
	
	private int rid;
	private String name;
	private String description;
	
}
