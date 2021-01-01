package get;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Bill;
import util.Utill;

public class GetBill {

	public boolean addBill(Bill bill) throws SQLException {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(bill);
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

	public ArrayList<Bill> getListBill() {
		Transaction transaction = null;
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Bill");
			listBill = (ArrayList<Bill>) query.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listBill;
	}

	public ArrayList<Bill> getListBillByUserID(int userID) {

		Transaction transaction = null;
		ArrayList<Bill> listBill = new ArrayList<Bill>();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Bill where userID =: uId");
			query.setParameter("uId", userID);
			listBill = (ArrayList<Bill>) query.getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listBill;

	}
}
