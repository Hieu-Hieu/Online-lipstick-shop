package get;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Brand;
import util.Utill;

public class BrandDAO {

	private Connection connection = null;

	public ArrayList<Brand> getListBrand() throws SQLException {
		Transaction transaction = null;
		ArrayList<Brand> listBrand = new ArrayList<Brand>();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Bill");
			listBrand = (ArrayList<Brand>) query.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listBrand;
	}

	public Brand getByID(int brandId) throws SQLException {
		Transaction transaction = null;
		Brand Brand = new Brand();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("select * from Brand where categoryID=: cID");
			query.setParameter("cID", brandId);
			Brand = (Brand) query.list().get(0);
//			session.get(Brand.class, brandId);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Brand;
	}

	public boolean insert(Brand b) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(b);
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

	public boolean update(Brand brand) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Brand set brandName = : bName where brandID: bID");
			query.setParameter("nName", brand.getBrandName());
			query.setParameter("bID", brand.getBrandID());
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

	public boolean delete(int brandID) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Brand where brandID: bID");
			query.setParameter("bID", brandID);
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
