package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Cartitems")

public class CartitemsWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer itemId;
	private int cartId;
	private int productId;
	private int qty;
	private double price;
	
	@XmlElement
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	@XmlElement
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	@XmlElement
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@XmlElement
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@XmlElement
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
