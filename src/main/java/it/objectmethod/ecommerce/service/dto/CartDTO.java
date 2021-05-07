package it.objectmethod.ecommerce.service.dto;

import java.util.List;

public class CartDTO {
	private Integer cartId;
	private Integer userId;
	private List<CartDetailDTO> cartList;

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

	public List<CartDetailDTO> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartDetailDTO> cartList) {
		this.cartList = cartList;
	}

}
