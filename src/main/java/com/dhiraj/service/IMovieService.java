package com.dhiraj.service;

import java.util.List;

import com.dhiraj.controller.dto.MovieDTO;

public interface IMovieService {

	void update(MovieDTO movie);

	void deleteByID(int id);

	MovieDTO findByID(int id);

	List<MovieDTO> getMovies();

	String save(MovieDTO movieDTO);

}
