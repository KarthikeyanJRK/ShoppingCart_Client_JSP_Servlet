package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
public class ProductWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer prId;
	private String name;
	private double unitPrice;
	private String brand;
	
	@XmlElement
	public Integer getPrId() {
		return prId;
	}
	
	public void setPrId(Integer prId) {
		this.prId = prId;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@XmlElement
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public ProductWS(Integer prId, String name, double unitPrice, String brand) {
		super();
		this.prId = prId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.brand = brand;
	}
	
	public ProductWS() {
		super();
	}
	
	
}
