package model;

public class BillDetail {
	private int billID;
	private int productID;
	private int quantity;

	public BillDetail() {

	}

	public BillDetail(int billID, int productID, int quantity) {
		super();
		this.billID = billID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
