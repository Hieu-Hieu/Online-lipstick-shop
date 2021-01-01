package get;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Category;
import util.Utill;

public class CategoryDAO {

	public ArrayList<Category> getListCategory() throws SQLException {
		Transaction transaction = null;
		ArrayList<Category> listCategory = new ArrayList<Category>();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Category");
			listCategory = (ArrayList<Category>) query.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listCategory;
	}

	public Category getByID(int categoryId) throws SQLException {
		Transaction transaction = null;
		Category Category = new Category();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select * from Category where categoryID=: cID");
			query.setParameter("cID", categoryId);
			Category = (Category) query.list().get(0);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Category;
	}

	public boolean insert(Category c) {
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

	public boolean updateCategory(Category category) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Category set categoryName = : cName where categoryID: cID");
			query.setParameter("cName", category.getCategoryName());
			query.setParameter("cID", category.getCategoryID());
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

	public boolean delete(int categoryID) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Category where categoryID: cID");
			query.setParameter("cID", categoryID);
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
}
