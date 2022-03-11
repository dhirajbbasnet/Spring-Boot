package com.dhiraj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.controller.dto.ApplicationResponseDTO;
import com.dhiraj.controller.dto.MovieDTO;
import com.dhiraj.service.IMovieService;

//Because, this is supposed to deal with raw data
@RestController

//prefix every url with v3
@RequestMapping("/v3")
public class MoviesRestController {

	@Autowired
	private IMovieService movieService;

//	When we get a get request with URI v3/movies, we get all the movies
	@GetMapping("/movies")
	public List<MovieDTO> getMovies() {
		return movieService.getMovies();
	}

	@GetMapping("/movies/{id}") // passing movie id in the URI
	// also using pathvariable to map the incoming id to the variable
	
	//@PathVariable is used to read the data into REST API from URI
	public MovieDTO findMovieByID(@PathVariable int id) {
		return movieService.findByID(id);
	}
	
	//Updating
	@PutMapping("/movies")
	public ApplicationResponseDTO updateMovie(@RequestBody MovieDTO movieDTO) {
		movieService.update(movieDTO);
		ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
		applicationResponseDTO.setCode("1002");
		applicationResponseDTO.setMessage("Movie Updated");
		return applicationResponseDTO;
	}
	
	
	//Creating
	@PostMapping("/movies")
	
	//Request body is like model attribute but it takes data from the incoming request body
	//and maps it into java object
	public ApplicationResponseDTO uploadMovies(@RequestBody MovieDTO movieDTO){
		movieService.save(movieDTO);
		ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
		applicationResponseDTO.setCode("1001");
		applicationResponseDTO.setMessage("Movie Uploaded");
		return applicationResponseDTO;
	}
	
	
	//Performing delete operation, we have created a new class only to return it
	@DeleteMapping("/movies/{id}")
	public ApplicationResponseDTO deleteMovieByID(@PathVariable int id) {
		movieService.deleteByID(id);
		ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
		applicationResponseDTO.setCode("1000");
		applicationResponseDTO.setMessage("Movie Deleted");
		return applicationResponseDTO;
	}
	
	//we can either use postman or curl command to delete
}
