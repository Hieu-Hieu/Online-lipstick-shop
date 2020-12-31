package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billDetail")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billDetailID")
	private int billDetailID;
	@OneToOne
	private Bill bill;
	@OneToMany
	@Column(name = "productID")
	private Product product;
	@Column(name = "quantity")
	private int quantity;

	public BillDetail() {

	}

	public BillDetail(int billDetailID, Bill bill, Product product, int quantity) {
		super();
		this.billDetailID = billDetailID;
		this.bill = bill;
		this.product = product;
		this.quantity = quantity;
	}

	public int getBillDetailID() {
		return billDetailID;
	}

	public void setBillDetailID(int billDetailID) {
		this.billDetailID = billDetailID;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
