package get;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Brand;
import model.Category;
import util.Utill;

public class CategoryDAO {

	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
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
			Query query = session.createQuery("from Category where categoryID=: cID");
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
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCategory (Category category)throws SQLException
	{
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			 session.update(category);
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

	public boolean delete(int categoryID) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Category cate = new Category();
			cate = session.get(Category.class, categoryID);
			if( cate != null) {
			session.delete(cate);
			// commit transaction
			transaction.commit();
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
	
	public ArrayList<Category> search(String input) throws SQLException {
		ArrayList<Category> listCategory = new ArrayList<Category>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Query<Category> query = session.createQuery("FROM Category WHERE categoryName LIKE :keyWord");
			query.setParameter("keyWord", "%" + input + "%");
			
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
	
	public boolean checkName(String name) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Category WHERE categoryName = : name");
			//Category result = session.get(Category.class, name);
			query.setParameter("name", name);
			if (query.executeUpdate() > 0) {
				return true;
			}
			//if(result != null) {
//				System.out.println("Trung ten brand");
//				return true;
//			}
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
