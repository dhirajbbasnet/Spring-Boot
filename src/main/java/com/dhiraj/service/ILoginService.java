package com.dhiraj.service;

import com.dhiraj.controller.dto.LoginDTO;

public interface ILoginService {

	boolean validateUser(LoginDTO loginDTO);

	boolean register(LoginDTO loginDTO, String admin, String employee, String customer);

}
