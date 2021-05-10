package it.objectmethod.ecommerce.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommerce.entity.Order;
import it.objectmethod.ecommerce.service.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
	
	@Override
	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "user.userName", target = "userName")
	OrderDTO toDto(Order entity);

	@Override
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "orderNum", ignore = true)
	Order toEntity(OrderDTO orderDto);

//	@Override
//	public Order toEntity(OrderDTO dto) {
//		Order entity = new Order();
//		entity.setOrderDate(dto.getOrderDate());
//		entity.setOrderId(dto.getOrderId());
//		entity.setOrderNum(dto.getOrderNum());
//
//		return entity;
//	}
//
//	@Override
//	public OrderDTO toDto(Order entity) {
//		OrderDTO dto = new OrderDTO();
//		dto.setOrderDate(entity.getOrderDate());
//		dto.setOrderId(entity.getOrderId());
//		dto.setOrderNum(entity.getOrderNum());
//		dto.setUserId(entity.getUser().getUserId());
//
//		return dto;
//	}
//
//	@Override
//	public List<Order> toEntity(List<OrderDTO> dtoList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<OrderDTO> toDto(List<Order> entityList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
