package it.objectmethod.ecommerce.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommerce.entity.Item;
import it.objectmethod.ecommerce.service.dto.ItemDTO;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
	
	@Override
	ItemDTO toDto(Item entity);

	@Override
	@Mapping(target = "availability", ignore = true)
	@Mapping(target = "itemCode", ignore = true)
	Item toEntity(ItemDTO itemDto);

//	@Override
//	public Item toEntity(ItemDTO dto) {
//		Item entity = new Item();
//		entity.setItemId(dto.getItemId());
//		entity.setAvailability(dto.getAvailability());
//		entity.setItemCode(dto.getItemCode());
//		entity.setItemName(dto.getItemName());
//		entity.setUnitPrice(dto.getUnitPrice());
//
//		return entity;
//	}
//
//	@Override
//	public ItemDTO toDto(Item entity) {
//		ItemDTO dto = new ItemDTO();
//		dto.setItemId(entity.getItemId());
//		dto.setAvailability(entity.getAvailability());
//		dto.setItemCode(entity.getItemCode());
//		dto.setItemName(entity.getItemName());
//		dto.setUnitPrice(entity.getUnitPrice());
//
//		return dto;
//	}
//
//	@Override
//	public List<Item> toEntity(List<ItemDTO> dtoList) {
//		List<Item> entityList = new ArrayList<Item>();
//		for (ItemDTO dto : dtoList) {
//			Item entity = new Item();
//			entity.setItemId(dto.getItemId());
//			entity.setAvailability(dto.getAvailability());
//			entity.setItemCode(dto.getItemCode());
//			entity.setItemName(dto.getItemName());
//			entity.setUnitPrice(dto.getUnitPrice());
//			entityList.add(entity);
//
//		}
//		return entityList;
//
//	}
//
//	@Override
//	public List<ItemDTO> toDto(List<Item> entityList) {
//		List<ItemDTO> dtoList = new ArrayList<>();
//		for (Item entity : entityList) {
//			ItemDTO dto = new ItemDTO();
//			dto.setItemId(entity.getItemId());
//			dto.setAvailability(entity.getAvailability());
//			dto.setItemCode(entity.getItemCode());
//			dto.setItemName(entity.getItemName());
//			dto.setUnitPrice(entity.getUnitPrice());
//			dtoList.add(dto);
//
//		}
//		return dtoList;
//	}

}
