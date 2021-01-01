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
			Query query = session.createQuery("select count(*) as tongTrang from Product");
			List listResult = query.list();
			Number number = (Number) listResult.get(0);
			total = (int) number.intValue();
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
			e.printStackTrace();
		}
		return 1;

	}

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

	public ArrayList<Product> getAllProduct(int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> listOfProduct = new ArrayList<Product>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Product");
			query.setFirstResult(firstResult);
			query.setMaxResults(lastResult);
			listOfProduct = (ArrayList<Product>) query.getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfProduct;
	}

	public Product getProductByID(int productID) throws SQLException {
		Product product = new Product();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			product = (Product) session.createQuery("from Product").list().get(0);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
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
