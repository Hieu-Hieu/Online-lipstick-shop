package get;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

//import connect.DBConnect;
import model.Product;
import util.Utill;

public class GetProduct {
//	DBConnect mydb = new DBConnect();
//	Connection conn = mydb.getConnecttion();

//	public int totalPage() throws SQLException {
//		int total = 0;
//		float result = 0;
//		PreparedStatement st = conn.prepareStatement("select count(*) as tongTrang from product");
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			total = rs.getInt("tongTrang");
//		}
//		result = (float) total / 9;
//		if (result > (total / 9)) {
//			return (int) (result + 1);
//		}
//		return (int) result;
//	}
	public int totalPage() throws SQLException {
		int total = 0;
		float result = 0;
		Transaction transaction = null;
		try {
			// start a transaction

			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT count(*) as tongTrang FROM Product";
			Query query = session.createQuery(sql);
			System.out.println("sdfsdfsd");
			List results = query.list();
			for (Object tong : results) {
				result = (float) ((List) tong).get(0);
			}

			result = (float) (results.get(0));
			result = (float) total / 9;
			if (result > (total / 9)) {
				return (int) (result + 1);
			}
			// commit transaction
			transaction.commit();
			return (int) result;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
//			e.printStackTrace();
			System.out.println(e.toString());
		}
		return 0;
//		PreparedStatement st = conn.prepareStatement("select count(*) as tongTrang from product");
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			total = rs.getInt("tongTrang");
//		}

	}

//	public boolean addProduct(Product p) throws SQLException {
//		PreparedStatement st = conn.prepareStatement("insert into product values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		st.setInt(1, p.getProductID());
//		st.setString(2, p.getName());
//		st.setInt(3, p.getCategoryID());
//		st.setString(4, p.getImgFirst());
//		st.setString(5, p.getImgLast());
//		st.setDouble(6, p.getPrice());
//		st.setString(7, p.getDescription());
//		st.setInt(8, p.getBrandID());
//		st.setInt(9, p.getQuantity());
//		if (st.executeUpdate() > 0) {
//			return true;
//		}
//		return false;
//	}
	public boolean addProduct(Product p) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the student object
			session.save(p);
			// commit transaction
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

//	public boolean deleteProduct(String productID) throws SQLException {
//		PreparedStatement st = conn.prepareStatement("delete from product where productID = ?");
//		st.setString(1, productID);
//
//		if (st.executeUpdate() > 0) {
//			return true;
//		}
//		return false;
//	}
	public boolean deleteProduct(String productID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Product where productID = :productID");
			query.setParameter("productID", productID);
			if (query.executeUpdate() > 0) {
				return true;
			}
			// commit transaction
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

//	public ArrayList<Product> getAllProduct(int firstResult, int lastResult) throws SQLException {
//		ArrayList<Product> list = new ArrayList<Product>();
//
//		PreparedStatement st = conn.prepareStatement("select * from product limit ?, ?");
//		st.setInt(1, firstResult);
//		st.setInt(2, lastResult);
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			Product product = new Product();
//			product.setProductID(rs.getInt("productID"));
//			product.setName(rs.getString("name"));
//			product.setCategoryID(rs.getInt("categoryID"));
//			product.setImgFirst(rs.getString("imgFirst"));
//			product.setImgLast(rs.getString("imgLast"));
//			product.setPrice(rs.getDouble("price"));
//			product.setDescription(rs.getString("description"));
//			product.setBrandID(rs.getInt("brandID"));
//			product.setQuantity(rs.getInt("quantity"));
//			list.add(product);
//		}
//		return list;
//	}
//
	public ArrayList<Product> getAllProduct(int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> list = new ArrayList<Product>();

		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Product");

			query.setFirstResult(firstResult);
			query.setMaxResults(lastResult);

			list = (ArrayList<Product>) query.getResultList();
//			;
//			for (Object results1 : results) {
//				list.add((Product) results1);
//			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}

//	public Product getProductByID(String productID) throws SQLException {
//		Product product = new Product();
//		PreparedStatement st = conn.prepareStatement("select * from product where productID = ?");
//		st.setString(1, productID);
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			product.setProductID(rs.getInt("productID"));
//			product.setName(rs.getString("name"));
//			product.setCategoryID(rs.getInt("categoryID"));
//			product.setImgFirst(rs.getString("imgFirst"));
//			product.setImgLast(rs.getString("imgLast"));
//			product.setPrice(rs.getDouble("price"));
//			product.setDescription(rs.getString("description"));
//			product.setBrandID(rs.getInt("brandID"));
//			product.setQuantity(rs.getInt("quantity"));
//		}
//		return product;
//	}
	public Product getProductByID(String productID) throws SQLException {
		Product product = new Product();

		return product;
	}

//
//	public ArrayList<Product> getProductByCategoryID(String categoryID, int firstResult, int lastResult)
//			throws SQLException {
//		ArrayList<Product> list = new ArrayList<Product>();
//		PreparedStatement st = conn.prepareStatement("select * from product where categoryID = ? limit ?, ?");
//		st.setString(1, categoryID);
//		st.setInt(2, firstResult);
//		st.setInt(3, lastResult);
//
//		ResultSet rs = st.executeQuery();
//		while (rs.next()) {
//			Product product = new Product();
//			product.setProductID(rs.getInt("productID"));
//			product.setName(rs.getString("name"));
//			product.setCategoryID(rs.getInt("categoryID"));
//			product.setImgFirst(rs.getString("imgFirst"));
//			product.setImgLast(rs.getString("imgLast"));
//			product.setPrice(rs.getDouble("price"));
//			product.setDescription(rs.getString("description"));
//			product.setBrandID(rs.getInt("brandID"));
//			product.setQuantity(rs.getInt("quantity"));
//			list.add(product);
//		}
//		return list;
//	}
//
//	public ArrayList<Product> getProductByBrandID(String BrandID, int firstResult, int lastResult) throws SQLException {
//		ArrayList<Product> list = new ArrayList<Product>();
//		PreparedStatement pst = conn.prepareStatement("select * from product where brandID = ? limit ?, ?");
//		pst.setString(1, BrandID);
//		pst.setInt(2, firstResult);
//		pst.setInt(2, lastResult);
//		ResultSet rs = pst.executeQuery();
//		while (rs.next()) {
//			Product product = new Product();
//			product.setProductID(rs.getInt("productID"));
//			product.setName(rs.getString("name"));
//			product.setCategoryID(rs.getInt("categoryID"));
//			product.setImgFirst(rs.getString("imgFirst"));
//			product.setImgLast(rs.getString("imgLast"));
//			product.setPrice(rs.getDouble("price"));
//			product.setDescription(rs.getString("description"));
//			product.setBrandID(rs.getInt("brandID"));
//			product.setQuantity(rs.getInt("quantity"));
//			list.add(product);
//		}
//
//		return list;
//
//	}
//
//	// search
//	public ArrayList<Product> search(String input) throws SQLException {
//		ArrayList<Product> list = new ArrayList<Product>();
//		PreparedStatement pst = conn.prepareStatement("select * from product where name like % ? %");
//		pst.setString(1, input);
//		ResultSet rs = pst.executeQuery();
//		while (rs.next()) {
//			Product product = new Product();
//			product.setProductID(rs.getInt("productID"));
//			product.setName(rs.getString("name"));
//			product.setCategoryID(rs.getInt("categoryID"));
//			product.setImgFirst(rs.getString("imgFirst"));
//			product.setImgLast(rs.getString("imgLast"));
//			product.setPrice(rs.getDouble("price"));
//			product.setDescription(rs.getString("description"));
//			product.setBrandID(rs.getInt("brandID"));
//			product.setQuantity(rs.getInt("quantity"));
//			list.add(product);
//		}
//		return list;
//	}

}
