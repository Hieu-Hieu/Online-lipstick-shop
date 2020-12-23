package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;

public class GetCart {
	DBConnect mydb = new DBConnect();
	Connection conn = mydb.getConnecttion();
	String sql = "select billID from bill where userID = ? and paid = false";

	public boolean checkProductExist(int userID, int productID) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("select * from billdetail where billID = (" + sql + ") and productID = ?");
		pst.setInt(1, userID);
		pst.setInt(2, productID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean checkBillExist(int userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from bill where userID = ? and paid = false");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean createBill(int userID) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into bill (userID, paid) values(?, false)");
			pst.setInt(1, userID);
			if (pst.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public int totalProduct(int userID) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("select sum(quantity) as quantity from billdetail where billID = (" + sql + ")");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			return rs.getInt("quantity");

		}
		return 0;
	}

	public boolean delete(int userID, int productID) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("delete from billdetail where billID = (" + sql + ") and productID = ?");
		pst.setInt(1, userID);
		pst.setInt(2, productID);

		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<List> getCartByUserID(int userID) throws SQLException {
		ArrayList<List> ListCart = new ArrayList<List>();
		PreparedStatement pst = conn.prepareStatement(
				"select c.productID, p.imgFirst, p.name, c.quantity, p.price from product p, (SELECT bd.productID, bd.quantity FROM bill b inner join billdetail bd on b.billID = bd.billID where b.userID = ? and b.paid = false) c where p.productID = c.productID");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		List listInfoProduct = new ArrayList();
		while (rs.next()) {
			List cart = new ArrayList();
			cart.add(rs.getString("productID"));
			cart.add(rs.getString("imgFirst"));
			cart.add(rs.getString("name"));
			cart.add(rs.getDouble("price"));
			cart.add(rs.getInt("quantity"));
			ListCart.add(cart);
		}
		return ListCart;
	}

	public double totalCart(int userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"select c.quantity as quantity, p.price as price from product p, (SELECT bd.productID, bd.quantity FROM bill b inner join billdetail bd on b.billID = bd.billID where b.userID = ? and paid = false) c where p.productID = c.productID");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		double totalCart = 0;

		while (rs.next()) {
			totalCart += rs.getDouble("price") * rs.getInt("quantity");
		}
		return totalCart;

	}

	public boolean addNewProductToCart(int userID, int productID, int quantity) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("insert into billdetail values (?, ?, ?)");
		pst.setInt(1, billID(userID));
		pst.setInt(2, productID);
		pst.setInt(3, quantity);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public int billID(int userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select billID from bill where userID = ? and paid = false");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return rs.getInt("billID");
		}
		return 0;
	}

	public boolean checkUserExist(int userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from bill where userID = ? and paid = false");
		pst.setInt(1, userID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean updateProductQuantity(int userID, int productID, int quantity) throws SQLException {
		int q = productQuantity(userID, productID) + quantity;
		PreparedStatement pst = conn
				.prepareCall("update billdetail set quantity = ? where billID = (" + sql + ") and productID = ?");
		pst.setInt(1, q);
		pst.setInt(2, userID);
		pst.setInt(3, productID);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean updateProductQuantityInCart(int userID, int productID, int quantity) throws SQLException {
		PreparedStatement pst = conn
				.prepareCall("update billdetail set quantity = ? where billID = (" + sql + ") and productID = ?");
		pst.setInt(1, quantity);
		pst.setInt(2, userID);
		pst.setInt(3, productID);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public int productQuantity(int userID, int productID) throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("select quantity from billdetail where billID = (" + sql + ") and productID = ?");
		pst.setInt(1, userID);
		pst.setInt(2, productID);
		ResultSet rs = pst.executeQuery();
		int total = 0;
		while (rs.next()) {
			total = rs.getInt("quantity");
		}
		return total;
	}
}
