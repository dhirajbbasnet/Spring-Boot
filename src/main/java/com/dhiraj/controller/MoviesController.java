package com.dhiraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhiraj.controller.dto.MovieDTO;
import com.dhiraj.service.IMovieService;
import com.dhiraj.service.MovieService;

//what is the default scope of spring bean? Singleton
//There are 7 scopes provided by spring
/*
 * singleton, prototype, request, application, session, global-session, socket
 */

@Controller
@Scope("singleton") // this is actually by default
public class MoviesController {

	@Autowired
	private IMovieService iMovieService;

	@GetMapping("/addMovie")
	public String getLogin() {
		return "addMovie";
	}

	@PostMapping("/addMovie")
	public String addMovie(@ModelAttribute MovieDTO movie, Model model) {
		iMovieService.save(movie);
		return "addMovie";
	}

	@GetMapping("/showAll")
	public String showAllMovies(Model model) {
		List<MovieDTO> movies = iMovieService.getMovies();
		model.addAttribute("movies", movies);
		return "showMovies";
	}

	@GetMapping("deleteMovie")
	public String delete(@RequestParam int id, Model model) {
		iMovieService.deleteByID(id);
//		List<Movie> movies = moviesDao.getMovies();
//		model.addAttribute("movies", movies);
//		return "showMovies";
		return "redirect:/showAll";
	}

	@GetMapping("/editMovie")
	public String edit(@RequestParam int id, Model model) {
		MovieDTO movie = iMovieService.findByID(id);
		model.addAttribute("movie", movie);
		return "editMovie";
	}

	@GetMapping("/updateMovie")
	public String update(@ModelAttribute MovieDTO movie, Model model) {
		
		iMovieService.update(movie);
//		List<Movie> movies = moviesDao.getMovies();
//		model.addAttribute("movies", movies);
//		return "showMovies";
		return "redirect:/showAll";
	}
}
