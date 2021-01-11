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

	public int totalPage(String sql) throws SQLException {
		int total = 0;
		float result = 0;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(sql);
			List listResult = query.list();
			Number number = (Number) listResult.size();
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

	public boolean updateProduct(Product p) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the student object
			session.update(p);
			// commit transaction
			transaction.commit();
			System.out.println("update thanh cong");
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(int productID) throws SQLException {
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

			product = session.get(Product.class, productID);

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

	public ArrayList<Product> getProductFilter(String sql, int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> listOfProduct = new ArrayList<Product>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(sql);
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

	// search
	public ArrayList<Product> search(String input, int firstResult, int lastResult) throws SQLException {
		ArrayList<Product> listOfProduct = new ArrayList<Product>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Product WHERE name LIKE :keyWord");
			query.setParameter("keyWord", "%" + input + "%");
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

	public int getQuantityByProductID(int productID) {
		int total = 0;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select quantity FROM Product WHERE productID = :productID");
			query.setParameter("productID", productID);
			List p = query.list();
			Number number = (Number) p.get(0);
			total = (int) number;
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return total;
	}

}
