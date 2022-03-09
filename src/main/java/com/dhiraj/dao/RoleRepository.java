package com.dhiraj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.dao.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

	RoleEntity findByName(String name);
	
}
