package get;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.User;
import util.Utill;

public class GetUser {
	public ArrayList<User> getListUser() throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			list = (ArrayList<User>) session.createQuery("From User").getResultList();
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

	public boolean checkEmail(String email) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("SELECT * FROM User WHERE email = :email");
			query.setParameter("email", email);
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

	// thêm tài khoản
	public boolean insertUser(User u) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("INSERT INTO User(username, password, email,phone, address)"
					+ "select username, password, email, phone, address from User");
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

	public User login(String username, String password) throws SQLException {
		User u = new User();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select * from user where username=:username and password=:password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			u = (User) query.list().get(0);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return u;
	}

	public User getUser(int id) throws SQLException {
		User u = new User();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("SELECT * FROM user WHERE userID = :userID");
			query.setParameter("userID", id);
			u = (User) query.list().get(0);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return u;
	}

	public boolean updateUser(User u) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"update user SET username=:uName, password=:pWord, email=:e,  phone=:p,address=:add WHERE userID = :uID");
			query.setParameter("uName", u.getUsername());
			query.setParameter("pWord", u.getPassword());
			query.setParameter("e", u.getEmail());
			query.setParameter("p", u.getPhone());
			query.setParameter("add", u.getAddress());
			query.setParameter("uID", u.getUserID());

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

}
