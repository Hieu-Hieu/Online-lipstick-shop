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
			Query query = session.createQuery("select * from Cart where userID = :uID and productID = :pID");
			query.setParameter("uID", userID);
			query.setParameter("pID", productID);
			List p = (List) query.list().get(0);

			if (p != null) {
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
			Query query = session.createQuery("select * from Cart where userID = :uID");
			query.setParameter("uID", userID);
			List p = (List) query.list().get(0);

			if (p != null) {
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

	public boolean addToCart(Cart c) {
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
		return false;
	}

	public int totalProduct(int userID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select sum(quantity) as quantity from Cart where userID =:uID");
			query.setParameter("uID", userID);
			String p = (String) query.list().get(0);
			if (p != null) {
				return Integer.parseInt(p);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}

	public boolean deleteProductInCart(int userID, int productID) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Cart where userID =:uID and productID: pID");
			query.setParameter("uID", userID);
			query.setParameter("pID", productID);
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
			Query query = session.createQuery("select * from Cart where userID: uID");
			query.setParameter("uID", userID);
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
			Query query = session.createQuery("select * from Cart where userID: uID");
			query.setParameter("uID", userID);
			list = (ArrayList<Cart>) query.getResultList();
			for (Cart l : list) {
				tong = l.getQuantity() + l.getProduct().getPrice();
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return tong;

	}

//	public boolean addNewProductToCart(int userID, int productID, int quantity) throws SQLException {
//		PreparedStatement pst = conn.prepareStatement("insert into billdetail values (?, ?, ?)");
//		pst.setInt(1, billID(userID));
//		pst.setInt(2, productID);
//		pst.setInt(3, quantity);
//		if (pst.executeUpdate() > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public int billID(int userID) throws SQLException {
//		PreparedStatement pst = conn.prepareStatement("select billID from bill where userID = ? and paid = false");
//		pst.setInt(1, userID);
//		ResultSet rs = pst.executeQuery();
//		if (rs.next()) {
//			return rs.getInt("billID");
//		}
//		return 0;
//	}
//
//	public boolean checkUserExist(int userID) throws SQLException {
//		PreparedStatement pst = conn.prepareStatement("select * from bill where userID = ? and paid = false");
//		pst.setInt(1, userID);
//		ResultSet rs = pst.executeQuery();
//		if (rs.next()) {
//			return true;
//		}
//		return false;
//	}
//
	public boolean updateProductQuantity(int userID, int productID, int quantity) throws SQLException {
		int q = productQuantity(userID, productID) + quantity;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Cart set quantity = : q where userID: uID and productID = :pID");
			query.setParameter("uID", userID);
			query.setParameter("q", quantity);
			query.setParameter("pID", productID);
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

//
//	public boolean updateProductQuantityInCart(int userID, int productID, int quantity) throws SQLException {
//		PreparedStatement pst = conn
//				.prepareCall("update billdetail set quantity = ? where billID = (" + sql + ") and productID = ?");
//		pst.setInt(1, quantity);
//		pst.setInt(2, userID);
//		pst.setInt(3, productID);
//		if (pst.executeUpdate() > 0) {
//			return true;
//		}
//		return false;
//	}
//
	public int productQuantity(int userID, int productID) throws SQLException {
		int quantity = 0;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("select sum(quantity) as quantity from Cart where userID =:uID and productID = : p");
			query.setParameter("uID", userID);
			query.setParameter("p", productID);
			String q = (String) query.list().get(0);
			if (q != null) {
				quantity = Integer.parseInt(q);
				return quantity;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}
}
