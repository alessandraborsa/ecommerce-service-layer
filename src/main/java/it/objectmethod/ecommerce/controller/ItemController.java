package it.objectmethod.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.ecommerce.service.ItemService;
import it.objectmethod.ecommerce.service.dto.ItemDTO;

@RestController
@RequestMapping("/api/")
public class ItemController {

	@Autowired
	private ItemService itemSrvc;

	@GetMapping("/articoli")
	public List<ItemDTO> showAll() {

		return itemSrvc.showAll();
	}

	@GetMapping("/find")
	public List<ItemDTO> showItem(@RequestParam("itemName") String itemName,
			@RequestParam("itemCode") String itemCode) {

		List<ItemDTO> item = itemSrvc.showItem(itemName, itemCode);
		return item;
	}
}
