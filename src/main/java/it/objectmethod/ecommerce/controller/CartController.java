package it.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommerce.service.CartService;
import it.objectmethod.ecommerce.service.dto.CartDTO;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartSrvc;

	@RequestMapping("/addItem")
	public ResponseEntity<CartDTO> saveItemToCart(@RequestParam("quantity") Integer quantity,
			@RequestParam("itemId") Integer itemId, @RequestParam("userId") Integer userId) {

		ResponseEntity<CartDTO> resp = null;

		CartDTO cartDto = cartSrvc.addCartItem(itemId, quantity, userId);
		if (cartDto != null) {
			resp = new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<CartDTO>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
