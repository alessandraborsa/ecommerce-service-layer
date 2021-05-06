package it.objectmethod.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommerce.entity.Cart;
import it.objectmethod.ecommerce.entity.CartDetail;
import it.objectmethod.ecommerce.entity.Order;
import it.objectmethod.ecommerce.entity.OrderRow;
import it.objectmethod.ecommerce.repository.CartRepository;
import it.objectmethod.ecommerce.repository.OrderRepository;
import it.objectmethod.ecommerce.repository.OrderRowRepository;
import it.objectmethod.ecommerce.service.dto.OrderDTO;
import it.objectmethod.ecommerce.service.mapper.OrderMapper;

@Service
public class OrderService {
	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderRowRepository rowRepo;

	@Autowired
	private OrderMapper ordMap;

	public OrderDTO insertOrder(Integer userId) {

		OrderDTO orderDto = null;
		Cart cart = cartRepo.findByUserUserId(userId);
		Order order = new Order();

		String code = "";
		String cartId = Integer.toString(cart.getCartId());
		if (cartId.length() == 3) {
			code = "A000" + cartId;
		} else if (cartId.length() == 4) {
			code = "A00" + cartId;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());

		order.setOrderNum(code);
		order.setUser(cart.getUser());
		order.setOrderDate(date);

		List<CartDetail> cartList = cart.getCartList();
		List<OrderRow> rowList = new ArrayList<OrderRow>();
		order = orderRepo.save(order);
		orderDto = ordMap.toDto(order);

		for (CartDetail ele : cartList) {
			OrderRow row = new OrderRow();
			row.setItem(ele.getItem());
			row.setQuantity(ele.getQuantity());
			row.setOrder(order);
			rowList.add(row);
			row = rowRepo.save(row);
		}

		order.setOrderRow(rowList);
		cartRepo.delete(cart);

		return orderDto;
	}
}