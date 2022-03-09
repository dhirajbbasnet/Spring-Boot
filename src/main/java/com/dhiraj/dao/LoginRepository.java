package com.dhiraj.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.dhiraj.dao.entity.LoginEntity;


public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{
	
	LoginEntity findByUsername(String username);
}
