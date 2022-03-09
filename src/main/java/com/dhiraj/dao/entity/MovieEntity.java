package com.dhiraj.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="movies")
public class MovieEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private int year;
	private String director;
	private String poster;
	private String story;
	
	//movieEntity is the name of the attribute on the other side of the
	//relationship, in this case movieEntity that is on MovieEntity class
	
	//mapped by is required in bidirectional mapping
	//no need to use joinColumn here 
	@OneToMany(mappedBy ="movieEntity" ,cascade = CascadeType.ALL)
	private List<ActorEntity> actors;
}
