package model;

public class BillDetail {
	private String billID;
	private String productID;
	private double price;
	private int quantity;
	
	public BillDetail(String billID, String productID, double price, int quantity) {
		super();
		this.billID = billID;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
	}
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
