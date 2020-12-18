package model;

public class Product {
	private int productID;
	private String name;
	private int categoryID;
	private int brandID;
	private String imgFirst;
	private String imgLast;
	private double price;
	private String description;
	private int quantity;

	public Product() {
	}

	public Product(int productID, String name, int categoryID, int brandID, String imgFirst, String imgLast,
			double price, String description, int quantity) {
		super();
		this.productID = productID;
		this.name = name;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.imgFirst = imgFirst;
		this.imgLast = imgLast;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
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

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
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
}
