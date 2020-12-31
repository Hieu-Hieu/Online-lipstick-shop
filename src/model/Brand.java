package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brandID")
	private int brandID;
	
	@Column(name = "brandName")
	private String brandName;

	//Mapping
	
		@OneToMany(mappedBy = "brand" , cascade=CascadeType.ALL)
		private Set<Product> products;
		
	public Brand() {
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Brand(int brandID, String brandName, Set<Product> products) {
		super();
		this.brandID = brandID;
		this.brandName = brandName;
		this.products = products;
	}

	
}
