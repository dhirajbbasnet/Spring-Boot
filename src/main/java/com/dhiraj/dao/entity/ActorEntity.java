package com.dhiraj.dao.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "actors_tbl")
public class ActorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String photo;
	private String role;
	private Timestamp createDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mid", unique = false)
	private MovieEntity movieEntity;
	
}
