package com.dhiraj.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.controller.dto.ActorDTO;
import com.dhiraj.dao.ActorRepository;
import com.dhiraj.dao.MoviesRepository;
import com.dhiraj.dao.entity.ActorEntity;
import com.dhiraj.dao.entity.MovieEntity;

@Service
public class ActorService implements IActorService{

	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Override
	public void save(ActorDTO actorDTO) {
		//getting the movie which has the same id we
		//got from the form
		MovieEntity movieEntity = moviesRepository.findById(actorDTO.getMid()).get();
		
		//copying the actorDTO into actorEntity
		ActorEntity actorEntity = new ActorEntity();
		BeanUtils.copyProperties(actorDTO, actorEntity);
		actorEntity.setCreateDate(new Timestamp(new Date().getTime()));
		//now setting the movieEntity id in actor to make relationship
		actorEntity.setMovieEntity(movieEntity);
		
		actorRepository.save(actorEntity);
	}
	
	@Override
	public List<ActorDTO> getActors(int mid){
		//getting movie of the id provided
		MovieEntity movieEntity =  moviesRepository.findById(mid).get();
		
		//since we have a bi directional relationship and each movie
		//object has a list of actors associated with it, we can load
		//the actors from the movie
		
		List<ActorEntity> actList = movieEntity.getActors();
		List<ActorDTO> actorDTOs = new ArrayList<ActorDTO>();
		//copying list from entity to DTO since this is going
		//from the database to the jsp
		for(ActorEntity actorEntity : actList) {
			ActorDTO actorDTO = new ActorDTO();
			BeanUtils.copyProperties(actorEntity, actorDTO);
			actorDTOs.add(actorDTO);
		}
		
		return actorDTOs;
		
	}

	@Override
	public List<ActorDTO> getActorsByOtherDirection(int mid) {
		
		//In the above method, we used movieEntity to get the actors 
		//here we will directly get data from ActorEntity
		//remember they are bidirectional
		
		MovieEntity movieEntity = moviesRepository.findById(mid).get();
		List<ActorEntity> actorEntities = actorRepository.findByMovieEntity(movieEntity);
		List<ActorDTO> actorDTOs = new ArrayList<ActorDTO>();
		
		for(ActorEntity actorEntity : actorEntities) {
			ActorDTO actorDTO = new ActorDTO();
			BeanUtils.copyProperties(actorEntity, actorDTO);
			actorDTOs.add(actorDTO);
		}
		
		return actorDTOs;
		
	}
	
	
}
