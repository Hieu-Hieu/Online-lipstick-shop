package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import get.GetCategory;
import get.GetBrand;
import model.Brand;
import model.Category;

import connect.DBConnect;
import model.Product;

public class GetProduct {
	
	DBConnect mydb = new DBConnect();
	Connection conn = mydb.getConnecttion();
	GetCategory getCategory=new GetCategory();
	GetBrand getBrand =new GetBrand();
	
	public int totalPage() throws SQLException {
		int total = 0;
		float result = 0;
		PreparedStatement st = conn.prepareStatement("select count(*) as tongTrang from product");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			total = rs.getInt("tongTrang");
		}
		result = (float) total / 9;
		if (result > (total / 9)) {
			return (int) (result + 1);
		}
		return (int) result;
	}

	public boolean addProduct(Product p) throws SQLException {

		PreparedStatement st = conn.prepareStatement("insert into product values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, p.getProductID());
		st.setString(2, p.getName());
		st.setString(3, p.getCategoryID());
		st.setString(4, p.getImgFirst());
		st.setString(5, p.getImgLast());
		st.setDouble(6, p.getPrice());
		st.setString(7, p.getDescription());
		st.setString(8, p.getBrandID());
		st.setInt(9, p.getQuantity());
		if (st.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteProduct(String productID) throws SQLException {
		PreparedStatement st = conn.prepareStatement("delete from product where productID = ?");
		st.setString(1, productID);

		if (st.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<Product> getAllProduct(int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement st = conn.prepareStatement("select * from product limit ?, ?");
		st.setInt(1, firstResult);
		st.setInt(2, lastResult);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Category category = getCategory.getCategoryByID(rs.getString("categoryID"));
			Brand brand = getBrand.getBrandByID(rs.getString("brandID"));
			Product product = new Product();
			product.setProductID(rs.getString("productID"));
			product.setName(rs.getString("name"));
			product.setCategoryID(rs.getString("categoryID"));
			product.setCategory(category);
			product.setImgFirst(rs.getString("imgFirst"));
			product.setImgLast(rs.getString("imgLast"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));
			product.setBrandID(rs.getString("brandID"));
			product.setBrand(brand);
			product.setQuantity(rs.getInt("quantity"));
			list.add(product);
		}
		return list;
	}

	public Product getProductByID(String productID) throws SQLException {
		Product product = new Product();
		PreparedStatement st = conn.prepareStatement("select * from product where productID = ?");
		st.setString(1, productID);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			product.setProductID(rs.getString("productID"));
			product.setName(rs.getString("name"));
			product.setCategoryID(rs.getString("categoryID"));
			product.setImgFirst(rs.getString("imgFirst"));
			product.setImgLast(rs.getString("imgLast"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));
			product.setBrandID(rs.getString("brandID"));
			product.setQuantity(rs.getInt("quantity"));
		}
		return product;
	}

	public ArrayList<Product> getProductByCategoryID(String categoryID, int firstResult, int lastResult)
			throws SQLException {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement st = conn.prepareStatement("select * from product where categoryID = ? limit ?, ?");
		st.setString(1, categoryID);
		st.setInt(2, firstResult);
		st.setInt(3, lastResult);

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Product product = new Product();
			product.setProductID(rs.getString("productID"));
			product.setName(rs.getString("name"));
			product.setCategoryID(rs.getString("categoryID"));
			product.setImgFirst(rs.getString("imgFirst"));
			product.setImgLast(rs.getString("imgLast"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));
			product.setBrandID(rs.getString("brandID"));
			product.setQuantity(rs.getInt("quantity"));
			list.add(product);
		}
		return list;
	}

	public ArrayList<Product> getProductByBrandID(String BrandID, int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pst = conn.prepareStatement("select * from product where brandID = ? limit ?, ?");
		pst.setString(1, BrandID);
		pst.setInt(2, firstResult);
		pst.setInt(2, lastResult);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Product product = new Product();
			product.setProductID(rs.getString("productID"));
			product.setName(rs.getString("name"));
			product.setCategoryID(rs.getString("categoryID"));
			product.setImgFirst(rs.getString("imgFirst"));
			product.setImgLast(rs.getString("imgLast"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));
			product.setBrandID(rs.getString("brandID"));
			product.setQuantity(rs.getInt("quantity"));
			list.add(product);
		}

		return list;

	}
	
	
	
}
