/*package com.dhiraj.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dhiraj.controller.dto.MovieDTO;
import com.dhiraj.dao.entity.MovieEntity;


@Repository
public class MoviesDao implements IMoviesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Using the Movies Repository that extends JPA Repository
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Override
	public String save(MovieEntity movie) {
//		String sql = "insert into movies(name,year,director,poster,story) values (?,?,?,?,?)";
//		Object[] data = {movie.getName(), movie.getYear(), movie.getDirector(), movie.getPoster(), movie.getStory()};
//		jdbcTemplate.update(sql,data);
		moviesRepository.save(movie);
		return "success";
	}
	
	@Override
	public List<MovieEntity> getMovies(){
		String sql = "select id, name, year, director, poster, story from movies";
		List<MovieEntity> movies = jdbcTemplate.query(sql, new BeanPropertyRowMapper(MovieEntity.class));
		return movies;
	}
	
	@Override
	public MovieEntity findByID(int id){
		String sql = "select id, name, year, director, poster, story from movies where id ="+id;
		List<MovieEntity> movies = jdbcTemplate.query(sql, new BeanPropertyRowMapper(MovieEntity.class));
		return movies.get(0);
	}
	
	@Override
	public void deleteByID(int id) {
		String sql = "delete from movies where id=" + id;
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void update(MovieEntity movie) {
		String sql = "update movies set name = ?, director = ?, poster =? where id = ?";
		Object[] data = {movie.getName(), movie.getDirector(), movie.getPoster(), movie.getId()};
		jdbcTemplate.update(sql, data);
	}
	
}*/
