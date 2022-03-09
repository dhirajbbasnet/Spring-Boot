package com.dhiraj.service;


import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.dhiraj.controller.dto.MovieDTO;
import com.dhiraj.dao.MoviesRepository;
import com.dhiraj.dao.ProducerRepository;
import com.dhiraj.dao.entity.MovieEntity;
import com.dhiraj.dao.entity.ProducerEntity;

@Service
public class MovieService implements IMovieService {
//Service layer does the conversion 
//	
//	@Autowired
//	private IMoviesDao iMoviesDao;
	
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@Override
	public String save(MovieDTO movieDTO) {
		MovieEntity entity  = new MovieEntity();
		BeanUtils.copyProperties(movieDTO, entity);//copying data from dto to entity
		//iMoviesDao.save(entity);
		
		ProducerEntity producerEntity = new ProducerEntity();
		producerEntity.setAddress("Naikap");
		producerEntity.setName("Dhiraj");
		producerEntity.setEmail("dhiraj@gmail.com");
		producerEntity.setMobile("9878765645");
		producerEntity.setCreateDate(new java.sql.Timestamp(new Date().getTime()));
		producerEntity.setMovieEntity(entity);
		
		//saving producer entity will save movie but not the 
		//other way around because right now only the producer 
		//entity has foreign key of movie
		producerRepository.save(producerEntity);
		return "success";
	}
	
	@Override
	public List<MovieDTO> getMovies(){
		//List<MovieEntity> movieEntities = iMoviesDao.getMovies();
		List<MovieEntity> movieEntities = moviesRepository.findAll();
		List<MovieDTO> dtos = new ArrayList<MovieDTO>();
		for(MovieEntity entity:movieEntities) {
			MovieDTO movieDTO = new MovieDTO();
			BeanUtils.copyProperties(entity, movieDTO);
			dtos.add(movieDTO);
		}
		return dtos;
	}
	
	@Override
	public MovieDTO findByID(int id){
	//MovieEntity entity =	iMoviesDao.findByID(id);
	MovieEntity entity = moviesRepository.findById(id).get();
	MovieDTO movieDTO = new MovieDTO();
	BeanUtils.copyProperties(entity, movieDTO);
	return movieDTO;
	}
	
	@Override
	public void deleteByID(int id) {
		moviesRepository.deleteById(id);
	}
	
	@Override
	public void update(MovieDTO movie) {
		MovieEntity entity = new MovieEntity();
		BeanUtils.copyProperties(movie, entity);
		moviesRepository.save(entity);
	}
	
}
