package com.dhiraj.dao.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles_tbl")
@Data
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	private String name;
	private String description;
	
	
	
}
