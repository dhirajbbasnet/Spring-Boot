package com.dhiraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhiraj.controller.dto.ActorDTO;
import com.dhiraj.service.IActorService;

@Controller
public class ActorController {

	@Autowired
	private IActorService actorService;
	
	@GetMapping("/addActor")
	public String showAddActor() {
		return "addActor";
	}
	
	@PostMapping("/addActor")
	public String addActorToMovie(@ModelAttribute ActorDTO actorDTO) {
		actorService.save(actorDTO);
		return "redirect:/showAll";
	}
		
	@GetMapping("/showActors")
	public String getActorPage(@RequestParam int id, Model model) {
		//List<ActorDTO> actors =  actorService.getActors(id);
		List<ActorDTO> actors =  actorService.getActorsByOtherDirection(id);
		model.addAttribute("actors", actors);
		return "allActors";
	}
	
}
