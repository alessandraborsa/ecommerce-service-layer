package it.objectmethod.ecommerce.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.objectmethod.ecommerce.entity.User;
import it.objectmethod.ecommerce.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
	
	@Override
	UserDTO toDto(User entity);

	@Override
	User toEntity(UserDTO dto);


//	@Override
//	public User toEntity(UserDTO dto) {
//		User entity = new User();
//		entity.setUserId(dto.getUserId());
//		entity.setUserName(dto.getUserName());
//
//		return entity;
//	}
//
//	@Override
//	public UserDTO toDto(User entity) {
//		UserDTO dto = new UserDTO();
//		dto.setUserId(entity.getUserId());
//		dto.setUserName(entity.getUserName());
//
//		return dto;
//	}
//
//	@Override
//	public List<User> toEntity(List<UserDTO> dtoList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<UserDTO> toDto(List<User> entityList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
