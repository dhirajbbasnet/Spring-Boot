package com.dhiraj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.dao.entity.ActorEntity;
import com.dhiraj.dao.entity.MovieEntity;

public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {

	List<ActorEntity> findByMovieEntity(MovieEntity movieEntity);
	
}
