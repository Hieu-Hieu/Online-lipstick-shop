package get;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Bill;
import model.User;
import util.Utill;

public class GetBill {

	public boolean addBill(Bill bill) throws SQLException {
		System.out.println("thêm bill thành công");
		Transaction transaction = null;
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(bill);
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

	public Bill getBillNew(User user) {
		Transaction transaction = null;
		Bill bill = new Bill();
		try {
			// start a transaction
			Session session = Utill.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"from Bill as b where b.billID not in (select bd.bill from BillDetail as bd) and b.user =:u");
			query.setParameter("u", user);
			bill = (Bill) query.list().get(0);
//			System.out.println(bill.getBillID());

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return bill;

	}
}
