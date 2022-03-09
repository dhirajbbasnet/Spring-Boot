package com.dhiraj.dao.entity;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "producer_tbl")
public class ProducerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String email;
	@Column(length = 15)
	private String mobile;
	@Column(length = 200)
	private String address;
	private Timestamp createDate;
	
	//mapping to the movie
	//assuming there is one to one relationship between them
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mid", unique = true)
	private MovieEntity movieEntity;
}
