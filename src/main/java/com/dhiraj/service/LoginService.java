package com.dhiraj.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.controller.dto.LoginDTO;
import com.dhiraj.dao.LoginDao;
import com.dhiraj.dao.LoginRepository;
import com.dhiraj.dao.RoleRepository;
import com.dhiraj.dao.entity.LoginEntity;
import com.dhiraj.dao.entity.MovieEntity;
import com.dhiraj.dao.entity.RoleEntity;

@Service
public class LoginService implements ILoginService {

//	@Autowired
//	private LoginDao loginDao;
//	
//	public boolean validateUser(String username, String password) {
//		boolean valid =  loginDao.validateUser(username, password);
//		return valid;
//	}

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public boolean validateUser(LoginDTO loginDTO) {
		LoginEntity loginEntity = new LoginEntity();
		BeanUtils.copyProperties(loginDTO, loginEntity);
		try {
			LoginEntity data = loginRepository.findByUsername(loginEntity.getUsername());
			if (data.getPassword().equals(loginEntity.getPassword())) {
				return true;
			}
		} catch (NullPointerException ex) {
			return false;
		}
		return false;
	}

	@Override
	public boolean register(LoginDTO loginDTO, String admin, String employee, String customer) {
		LoginEntity loginEntity = new LoginEntity();
		BeanUtils.copyProperties(loginDTO, loginEntity);
		Set<RoleEntity> roles = new HashSet<RoleEntity>();

		if (!admin.isEmpty()) {
			RoleEntity roleEntity = roleRepository.findByName(admin);
			roles.add(roleEntity);
		}
		if (!employee.isEmpty()) {
			RoleEntity roleEntity = roleRepository.findByName(employee);
			roles.add(roleEntity);
		}
		if (!customer.isEmpty()) {
			RoleEntity roleEntity = roleRepository.findByName(customer);
			roles.add(roleEntity);
		}
		
		loginEntity.setRoles(roles);
		
		try {
		loginRepository.save(loginEntity);	
		}catch(Exception ex)
		{
			return false;
		}
		return true;
	}

}
