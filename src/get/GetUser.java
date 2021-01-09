package get;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.User;
import util.Utill;

public class GetUser {

	@SuppressWarnings("unchecked")
	public List<User> getListUser() throws SQLException {

		Transaction transaction = null;
		List<User> listOfUser = null;
		try (Session session = Utill.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object

			listOfUser = session.createQuery("from User").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}

	public boolean checkEmail(String email) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE email = :email");
			query.setParameter("email", email);
			// commit transaction
			transaction.commit();
			if (transaction != null) {
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkData(String sql) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(sql);
			List l = query.list();
			if (l.isEmpty()) {
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
			session.save(u);
			// commit transaction
			transaction.commit();
			if (transaction != null) {
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public User login(String email, String password) throws SQLException {
		User u = null;
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where email = :email and password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			List l = query.list();
			if (!l.isEmpty()) {
				u = (User) l.get(0);
			}
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

	public User getUserByID(int id) throws SQLException {
		User u = new User();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			u = session.get(User.class, id);
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
			session.update(u);
			// commit transaction
			transaction.commit();
			if (transaction != null) {
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserInfo(int userID, String username, String phone, String email, String address) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery(
					"update User set username = :username, phone = :phone, address = :address, email =: email where userID = :uID");
			q.setParameter("username", username);
			q.setParameter("phone", phone);
			q.setParameter("address", address);
			q.setParameter("email", email);
			q.setParameter("uID", userID);
			if (q.executeUpdate() > 0) {
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

	public boolean updateUserPass(String email, String password) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery("update User set password=:password where email =: email");
			q.setParameter("password", password);
			q.setParameter("email", email);
			if (q.executeUpdate() > 0) {
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
