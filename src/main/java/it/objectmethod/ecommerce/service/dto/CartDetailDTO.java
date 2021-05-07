package it.objectmethod.ecommerce.service.dto;

public class CartDetailDTO {
	
	private Integer cartDetailId;
	private Integer quantity;
	private ItemDTO item;

	public Integer getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(Integer cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}

}
