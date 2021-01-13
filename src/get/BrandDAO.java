package get;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Brand;
import model.Product;
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
			Query<Brand> query = session.createQuery("from Brand");
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
		Brand brand = new Brand();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			brand = session.get(Brand.class, brandId);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return brand;
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
			Query<Brand> query = session.createQuery("update Brand set brandName = : bName where brandID =: bID");
			query.setParameter("bName", brand.getBrandName());
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
			Query<Brand> query = session.createQuery("delete from Brand where brandID =: bID");
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Brand> search(String input) throws SQLException {
		ArrayList<Brand> listOfBrand = new ArrayList<Brand>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
		//	Query<Brand> query =	session.createQuery("select at from Brand at where lower(at.brand.brandName) LIKE lower(:keyWord)",Brand.class);  

			Query<Brand> query = session.createQuery("FROM Brand WHERE brandName LIKE :keyWord");
			query.setParameter("keyWord", "%" + input + "%");
			
			listOfBrand = (ArrayList<Brand>) query.getResultList();
			// commit transaction
			transaction.commit();
			System.out.println(listOfBrand);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println(listOfBrand);
		return listOfBrand;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Product> getProductListByName(String productName) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  Session session = sessionFactory.openSession();
		  @SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Product.class);
		  
		    criteria.add(Restrictions.like("name", "%"+productName+"%"));
		  
		  ArrayList<Product> result = (ArrayList<Product>) criteria.list();
		  session.close();
		  sessionFactory.close();
		  return result;

	}
//		}
//	 catch (Exception e) {
//		if (transaction != null) {
//			transaction.rollback();
//		}
//		e.printStackTrace();
//	}
//		 return productsName;
//	}
}
