package com.dhiraj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.dao.entity.ProducerEntity;

//creating a repository for producer entity
//each entity needs a repository

public interface ProducerRepository extends JpaRepository<ProducerEntity, Integer> {

}
