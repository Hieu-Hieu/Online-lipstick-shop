package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productID")
	private int productID;
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "brandID")
	private Brand brand;

	@Column(name = "imgFirst")
	private String imgFirst;

	@Column(name = "imgLast")
	private String imgLast;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	// maping

//	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
//	private Set<BillDetail> billDetail;
//	
	public Product() {

	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getImgFirst() {
		return imgFirst;
	}

	public void setImgFirst(String imgFirst) {
		this.imgFirst = imgFirst;
	}

	public String getImgLast() {
		return imgLast;
	}

	public void setImgLast(String imgLast) {
		this.imgLast = imgLast;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(int productID, String name, Category category, Brand brand, String imgFirst, String imgLast,
			double price, String description, int quantity) {
		super();
		this.productID = productID;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.imgFirst = imgFirst;
		this.imgLast = imgLast;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

}
