package entities;

public class Items {

	private ProductWS productWS;
	private int qty;
	
	
	public ProductWS getProductWS() {
		return productWS;
	}
	
	public void setProductWS(ProductWS productWS) {
		this.productWS = productWS;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Items(ProductWS productWS, int qty) {
		super();
		this.productWS = productWS;
		this.qty = qty;
	}

	public Items() {
		super();
	}
	
	
	
}
