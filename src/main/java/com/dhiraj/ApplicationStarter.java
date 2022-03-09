package com.dhiraj;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhiraj.dao.RoleRepository;
import com.dhiraj.dao.entity.RoleEntity;

/*
 * This is responsible to start our application
 */

@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}

	// pre populating data using command line runner
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//see if there is data there already
		List<RoleEntity> optional = roleRepository.findAll();

		if(optional.isEmpty()) {
			RoleEntity roleEntity1 = new RoleEntity();
			roleEntity1.setName("Admin");
			roleEntity1.setDescription("Fkin Admin");
			roleRepository.save(roleEntity1);
			
			RoleEntity roleEntity2 = new RoleEntity();
			roleEntity2.setName("Employee");
			roleEntity2.setDescription("Fkin Employee");
			roleRepository.save(roleEntity2);
			
			RoleEntity roleEntity3 = new RoleEntity();
			roleEntity3.setName("Customer");
			roleEntity3.setDescription("Fkin Customer");
			roleRepository.save(roleEntity3);
		}
	}

}