package it.objectmethod.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommerce.service.OrderService;
import it.objectmethod.ecommerce.service.dto.OrderDTO;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService ordSrvc;

	@PostMapping("/neworder")
	public ResponseEntity<OrderDTO> insertOrder(@RequestParam("userId") Integer userId) {

		ResponseEntity<OrderDTO> resp = null;
		OrderDTO orderDto = ordSrvc.insertOrder(userId);
		if (orderDto != null) {
			resp = new ResponseEntity<OrderDTO>(orderDto, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<OrderDTO>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
