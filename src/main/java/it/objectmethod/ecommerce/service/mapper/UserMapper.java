package it.objectmethod.ecommerce.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import it.objectmethod.ecommerce.entity.User;
import it.objectmethod.ecommerce.service.dto.UserDTO;

@Component
public class UserMapper implements EntityMapper<UserDTO, User> {

	@Override
	public User toEntity(UserDTO dto) {
		User entity = new User();
		entity.setUserId(dto.getUserId());
		entity.setUserName(dto.getUserName());

		return entity;
	}

	@Override
	public UserDTO toDto(User entity) {
		UserDTO dto = new UserDTO();
		dto.setUserId(entity.getUserId());
		dto.setUserName(entity.getUserName());

		return dto;
	}

	@Override
	public List<User> toEntity(List<UserDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> toDto(List<User> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
