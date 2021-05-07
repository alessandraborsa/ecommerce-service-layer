package it.objectmethod.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(ItemService.class);

	public List<ItemDTO> showItem(String itemCode, String itemName) {
		
		logger.info("Richiesta ricerca articolo per nome [" + itemName + "] e per codice [" + itemCode + "]");
		
		List<Item> items = itemRepo.findItems(itemCode, itemName);
		List<ItemDTO> itemsDto = itemMapper.toDto(items);
		return itemsDto;
	}

	public List<ItemDTO> showAll() {
		List<Item> items = itemRepo.showAllItems();
		List<ItemDTO> itemsDto = itemMapper.toDto(items);
		return itemsDto;

	}
}