package com.dhiraj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhiraj.controller.dto.LoginDTO;
import com.dhiraj.dao.LoginDao;
import com.dhiraj.service.ILoginService;
import com.dhiraj.service.LoginService;

//This is our model class. Model class are controller class, not the front controller
@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@GetMapping({ "/login", "/" })
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute LoginDTO loginDTO) {
//		
//		LoginDTO loginDTO = new LoginDTO();
//		loginDTO.setUsername(username);
//		loginDTO.setPassword(password);
		
		boolean login = loginService.validateUser(loginDTO);
		
		return (login)?"home":"login"; //if login us true return home else return login
	}

	@GetMapping("/register")
	public String loadRegisterPage() {
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute LoginDTO loginDTO, @RequestParam String admin, @RequestParam String employee, @RequestParam String customer) {
		System.out.println(admin +"  " + employee + "  " + customer );
		loginService.register(loginDTO, admin, employee, customer);
		return "/register";
	}
	
}
