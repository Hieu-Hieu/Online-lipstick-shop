//package get;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import connect.DBConnect;
//import model.Bill;
//
//public class GetBill {
//
//	DBConnect mydb = new DBConnect();
//	Connection conn = mydb.getConnecttion();
//
//	public boolean addBill(Bill bill) throws SQLException {
//		String sql = "Insert into bill values(?,?,?,?,?,?)";
//		PreparedStatement ps = conn.prepareStatement(sql);
//
//		ps.setInt(1, bill.getBillID());
//		ps.setInt(2, bill.getUserID());
//		ps.setString(4, bill.getAddress());
//		ps.setDate(5, bill.getDate());
//		ps.setDouble(3, bill.getTotal());
//		ps.setBoolean(6, bill.getPaid());
//		if (ps.executeUpdate() > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public ArrayList<Bill> getListBill() {
//		try {
//			String sql = "Select * from bill";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			ArrayList<Bill> list = new ArrayList<>();
//
//			while (rs.next()) {
//				Bill bill = new Bill();
//
//				bill.setBillID(rs.getInt("billID"));
//				bill.setUserID(rs.getInt("userID"));
//				bill.setDate(rs.getDate("date"));
//				bill.setAddress(rs.getString("address"));
//				bill.setTotal(rs.getDouble("total"));
//				bill.setPaid(rs.getBoolean("paid"));
//				list.add(bill);
//			}
//			return list;
//
//		} catch (SQLException ex) {
//			Logger.getLogger(GetBill.class.getName()).log(Level.SEVERE, null, ex);
//		}
//
//		return null;
//	}
//
//	public ArrayList<Bill> getListBillByUserID(String userID) {
//
//		try {
//			String sql = "Select * from bill WHERE userID = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, userID);
//			ResultSet rs = ps.executeQuery();
//			ArrayList<Bill> list = new ArrayList<>();
//
//			while (rs.next()) {
//
//				Bill bill = new Bill();
//
//				bill.setBillID(rs.getInt("billID"));
//				bill.setUserID(rs.getInt("userID"));
//				bill.setDate(rs.getDate("date"));
//				bill.setAddress(rs.getString("address"));
//				bill.setTotal(rs.getDouble("total"));
//
//				list.add(bill);
//			}
//			return list;
//
//		} catch (SQLException ex) {
//			Logger.getLogger(GetBill.class.getName()).log(Level.SEVERE, null, ex);
//		}
//
//		return null;
//
//	}
//
//}
