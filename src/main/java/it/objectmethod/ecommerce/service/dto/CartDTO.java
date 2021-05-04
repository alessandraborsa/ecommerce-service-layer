package it.objectmethod.ecommerce.service.dto;

import java.util.List;
import it.objectmethod.ecommerce.entity.CartDetail;

public class CartDTO {
	private Integer cartId;
	private Integer userId;
	private List<CartDetail> cartList;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<CartDetail> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartDetail> cartList) {
		this.cartList = cartList;
	}

}
