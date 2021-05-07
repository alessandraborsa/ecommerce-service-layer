package it.objectmethod.ecommerce.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.ecommerce.entity.User;
import it.objectmethod.ecommerce.repository.UserRepository;
import it.objectmethod.ecommerce.service.dto.UserDTO;
import it.objectmethod.ecommerce.service.mapper.UserMapper;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserMapper userMapper;
	
	private static final Logger logger = LogManager.getLogger(UserService.class);

	public UserDTO loginUser(String userName, String password) {
		
		logger.info("Richieta di login per l'utente [" + userName + "]");

		UserDTO userDto = null;
		User user = userRepo.findByUserAndPassword(userName, password);
		if (user != null) {
			userDto = userMapper.toDto(user);
		}
		return userDto;
	}

}