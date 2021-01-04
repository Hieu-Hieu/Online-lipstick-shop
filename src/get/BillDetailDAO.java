package get;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.BillDetail;
import util.Utill;

public class BillDetailDAO {
	public boolean addBilldetail(BillDetail bd) {
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(bd);
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

	public ArrayList<BillDetail> getAllBilldetail(int billID) {
		ArrayList<BillDetail> billDetail = new ArrayList<BillDetail>();
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery("from BillDetail where billID: billID");
			q.setParameter("billId", billID);
			billDetail = (ArrayList<BillDetail>) q.list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return billDetail;
	}
}
