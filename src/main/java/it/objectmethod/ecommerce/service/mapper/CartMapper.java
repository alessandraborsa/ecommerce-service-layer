package it.objectmethod.ecommerce.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import it.objectmethod.ecommerce.entity.Cart;
import it.objectmethod.ecommerce.service.dto.CartDTO;

@Component
public class CartMapper implements EntityMapper<CartDTO, Cart> {

	@Override
	public Cart toEntity(CartDTO dto) {
		Cart entity = new Cart();
		entity.setCartId(dto.getCartId());
		
		return entity;
	}

	@Override
	public CartDTO toDto(Cart entity) {
		CartDTO dto = new CartDTO();
		dto.setCartId(entity.getCartId());
		dto.setUserId(entity.getUser().getUserId());

		return dto;
	}

	@Override
	public List<Cart> toEntity(List<CartDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartDTO> toDto(List<Cart> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
