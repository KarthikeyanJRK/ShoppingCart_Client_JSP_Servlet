package entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Cusorder")
public class CusorderWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private int cartId;
	private int payId;
	private Date billDate;
	private double discount;
	private double total;
	private int shipId;
	
	@XmlElement
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@XmlElement
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	@XmlElement
	public int getPayId() {
		return payId;
	}
	
	public void setPayId(int payId) {
		this.payId = payId;
	}
	
	@XmlElement
	public Date getBillDate() {
		return billDate;
	}
	
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	@XmlElement
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@XmlElement
	public double getTotal() {
		return total;
	}
	
	@XmlElement
	public void setTotal(double total) {
		this.total = total;
	}
	
	@XmlElement
	public int getShipId() {
		return shipId;
	}
	
	@XmlElement
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}


/*	public CusorderWS(Integer orderId, int cartId, int payId, Date billDate, double discount, double total,
			int shipId) {
		super();
		this.orderId = orderId;
		this.cartId = cartId;
		this.payId = payId;
		this.billDate = billDate;
		this.discount = discount;
		this.total = total;
		this.shipId = shipId;
	}

	public CusorderWS() {
		super();
	}
	
	*/
	
}
