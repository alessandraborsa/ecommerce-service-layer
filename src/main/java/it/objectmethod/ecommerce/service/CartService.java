package it.objectmethod.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommerce.entity.Item;
import it.objectmethod.ecommerce.entity.Cart;
import it.objectmethod.ecommerce.entity.CartDetail;
import it.objectmethod.ecommerce.entity.User;
import it.objectmethod.ecommerce.repository.ItemRepository;
import it.objectmethod.ecommerce.repository.CartRepository;
import it.objectmethod.ecommerce.repository.UserRepository;
import it.objectmethod.ecommerce.service.dto.CartDTO;
import it.objectmethod.ecommerce.service.mapper.CartMapper;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ItemRepository itemRepo;
	
	private static final Logger logger = LogManager.getLogger(CartService.class);

	public CartDTO addCartItem(Integer quantity, Integer itemId, Integer userId) {
		
	

		User user = userRepo.findById(userId).get();
		Optional<Item> it = itemRepo.findById(itemId);
		CartDTO cartDto = null;
		boolean newItem = true;

		if (it.isPresent()) {

			Item item = it.get();

			if (quantity <= item.getAvailability()) {

				Cart cart = null;
				cart = cartRepo.findByUserUserId(userId);

				if (cart == null) {
					cart = new Cart();
					cart.setUser(user);
					cart.setCartList(new ArrayList<CartDetail>());

					CartDetail detail = new CartDetail();
					detail.setItem(item);
					detail.setQuantity(quantity);
					List<CartDetail> list = cart.getCartList();
					list.add(detail);
					cart.setCartList(list);

				} else {

					for (CartDetail ele : cart.getCartList()) {

						if (ele.getItem().getItemId() == item.getItemId()) {
							ele.setQuantity(quantity + ele.getQuantity());
							newItem = false;
						}
					}
					if (newItem) {

						CartDetail detail = new CartDetail();
						detail.setItem(item);
						detail.setQuantity(quantity);
						List<CartDetail> list = cart.getCartList();
						list.add(detail);
						cart.setCartList(list);
					}
				}

				item.setAvailability(item.getAvailability() - quantity);
				item = itemRepo.save(item);
				cart = cartRepo.save(cart);

				cartDto = cartMapper.toDto(cart);
				

			}

		}
		return cartDto;

	}

}