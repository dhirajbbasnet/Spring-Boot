package com.dhiraj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.dao.entity.MovieEntity;

//interface dao that extends JPA repository and type is the MovieEntity class
//which has Integer type of primary key

public interface MoviesRepository extends JpaRepository<MovieEntity, Integer> {

	
	
}
