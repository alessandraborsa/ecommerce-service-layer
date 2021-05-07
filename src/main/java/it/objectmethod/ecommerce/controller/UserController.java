package it.objectmethod.ecommerce.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommerce.service.JWTService;
import it.objectmethod.ecommerce.service.UserService;
import it.objectmethod.ecommerce.service.dto.UserDTO;

@RestController

@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JWTService jwtService;

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@RequestMapping("/login")
	public ResponseEntity<String> userLogin(@RequestParam("username") String userName,
			@RequestParam("password") String password) {

		logger.info("Richiesta di login con nome utente: [" + userName + "]");

		ResponseEntity<String> resp = null;
		UserDTO userDto = userService.loginUser(userName, password);
		if (userDto != null) {

			String token = jwtService.getUserToken(userDto);

			resp = new ResponseEntity<>(token, HttpStatus.OK);

		} else {
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return resp;
	}

}