package it.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommerce.service.UserService;
import it.objectmethod.ecommerce.service.dto.UserDTO;

@RestController
public class UserController {

	@Autowired
	private UserService userSrvc;

	@PostMapping("/userlogin")
	public UserDTO userLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		UserDTO userLogged = null;
		userLogged = userSrvc.loginUser(userName, password);
		
		return userLogged;
	}
}
