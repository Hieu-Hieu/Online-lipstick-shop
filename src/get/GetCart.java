package get;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Cart;
import util.Utill;

public class GetCart {

	public boolean checkProductExist(int userID, int productID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart where userID = :userID and productID = :productID");
			query.setParameter("userID", userID);
			query.setParameter("productID", productID);
			List p = query.list();
			if (!p.isEmpty()) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkCartExist(int userID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart where userID = :userID");
			query.setParameter("userID", userID);
			List p = query.list();
			if (!p.isEmpty()) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public void addToCart(Cart c) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(c);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public int totalProduct(int userID) throws SQLException {
		Transaction transaction = null;
		Number number = 0;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select sum(quantity) as quantity from Cart where userID = :userID");
			query.setParameter("userID", userID);
			List p = query.list();
			if (p.get(0) != null) {
				number = (Number) p.get(0);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return (int) number.intValue();
	}

	public boolean deleteProductInCart(int userID, int productID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Cart where userID = :userID and productID = :productID");
			query.setParameter("userID", userID);
			query.setParameter("productID", productID);
			if (query.executeUpdate() > 0)
				return true;
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCartByUserID(int userID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Cart where userID = :userID");
			query.setParameter("userID", userID);
			if (query.executeUpdate() > 0)
				return true;
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Cart> getCartByUserID(int userID) throws SQLException {
		ArrayList<Cart> ListCart = new ArrayList<Cart>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart where userID = :userID");
			query.setParameter("userID", userID);
			ListCart = (ArrayList<Cart>) query.getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return ListCart;
	}

	public double totalCart(int userID) throws SQLException {
		Transaction transaction = null;
		double tong = 0;
		ArrayList<Cart> list = new ArrayList<Cart>();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart where userID = :userID");
			query.setParameter("userID", userID);
			list = (ArrayList<Cart>) query.getResultList();
			for (Cart l : list) {
				tong = l.getQuantity() * l.getProduct().getPrice();
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println(tong);
		return tong;

	}

	public boolean updateProductQuantity(int userID, int productID, int quantity) throws SQLException {
		int q = productQuantity(userID, productID) + quantity;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"update Cart set quantity = :quantity where userID = :userID and productID = :productID");
			query.setParameter("userID", userID);
			query.setParameter("quantity", q);
			query.setParameter("productID", productID);
			if (query.executeUpdate() > 0) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProductQuantityInCart(int userID, int productID, int quantity) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"update Cart set quantity = :quantity where userID = :userID and productID = :productID");
			query.setParameter("userID", userID);
			query.setParameter("quantity", quantity);
			query.setParameter("productID", productID);
			if (query.executeUpdate() > 0) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public int productQuantity(int userID, int productID) throws SQLException {
		int quantity = 0;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"select sum(quantity) as quantity from Cart where userID = :userID and productID = :productID");
			query.setParameter("userID", userID);
			query.setParameter("productID", productID);
			List p = query.list();
			Number number = (Number) p.get(0);
			// commit transaction
			transaction.commit();
			return (int) number.intValue();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}
}
