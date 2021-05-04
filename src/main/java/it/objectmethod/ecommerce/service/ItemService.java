package it.objectmethod.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.ecommerce.entity.Item;
import it.objectmethod.ecommerce.repository.ItemRepository;
import it.objectmethod.ecommerce.service.dto.ItemDTO;
import it.objectmethod.ecommerce.service.mapper.ItemMapper;

@Component
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ItemMapper itemMapper;

	public List<ItemDTO> showItem(String itemCode, String ItemName) {
		
		List<Item> items = itemRepo.findItems(itemCode, ItemName);
		List<ItemDTO> itemsDto = itemMapper.toDto(items);
		return itemsDto;
	}

	public List<ItemDTO> showAll() {
		List<Item> items = itemRepo.showAllItems();
		List<ItemDTO> itemsDto = itemMapper.toDto(items);
		return itemsDto;

	}
}