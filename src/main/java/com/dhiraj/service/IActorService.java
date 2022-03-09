package com.dhiraj.service;

import java.util.List;

import com.dhiraj.controller.dto.ActorDTO;

public interface IActorService {

	void save(ActorDTO actorDTO);


	List<ActorDTO> getActorsByOtherDirection(int mid);


	List<ActorDTO> getActors(int mid);

}
