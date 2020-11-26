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

	public boolean checkExist(String userID, String productID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from cart where userID = ? and productID = ?");
		pst.setString(1, userID);
		pst.setString(2, productID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public int totalProduct(String userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select sum(quantity) as quantity from cart where userID = ?");
		pst.setString(1, userID);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			return rs.getInt("quantity");
		}
		return 0;
	}

	public boolean delete(String userID, String productID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("delete from cart where userID = ? and productID = ?");
		pst.setString(1, userID);
		pst.setString(2, productID);

		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<List> getCartByUserID(String userID) throws SQLException {
		ArrayList<List> ListCart = new ArrayList<List>();
		PreparedStatement pst = conn.prepareStatement(
				"SELECT c.productID, p.imgFirst, p.name, c.quantity, p.price FROM (select productID, quantity from cart where userID = ?) as c inner join product p on c.productID= p.productID");
		pst.setString(1, userID);
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

	public double totalCart(String userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement(
				"SELECT c.quantity as quantity, p.price as price FROM (select productID, quantity from cart where userID = ?) as c inner join product p on c.productID= p.productID");
		pst.setString(1, userID);
		ResultSet rs = pst.executeQuery();
		double totalCart = 0;

		while (rs.next()) {
			totalCart += rs.getDouble("price") * rs.getInt("quantity");
		}
		System.out.println(totalCart);
		return totalCart;

	}
//	public ArrayList<Cart> getCartByUserID(String userID) throws SQLException {
//		ArrayList<Cart> ListCart = new ArrayList<Cart>();
//		PreparedStatement pst = conn.prepareStatement("select * from cart where userID = ?");
//		ResultSet rs = pst.executeQuery();
//		while (rs.next()) {
//			Cart cart = new Cart();
//			cart.setUserID(rs.getString("userID"));
//			cart.setProductID(rs.getString("productID"));
//			cart.setQuantity(rs.getInt("quantity"));
//			ListCart.add(cart);
//		}
//		return ListCart;
//	}

	public boolean addToCart(String userID, String productID, int quantity) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("insert into cart values (?, ?, ?)");
		pst.setString(1, userID);
		pst.setString(2, productID);
		pst.setInt(3, quantity);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean checkUserExist(String userID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from cart where userID = ?");
		pst.setString(1, userID);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean updateProductQuantity(String userID, String productID, int quantity) throws SQLException {
		int q = productQuantity(userID, productID) + quantity;
		PreparedStatement pst = conn.prepareCall("update cart set quantity = ? where userID = ? and productID = ?");
		pst.setInt(1, q);
		pst.setString(2, userID);
		pst.setString(3, productID);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean updateProductQuantityInCart(String userID, String productID, int quantity) throws SQLException {
		PreparedStatement pst = conn.prepareCall("update cart set quantity = ? where userID = ? and productID = ?");
		pst.setInt(1, quantity);
		pst.setString(2, userID);
		pst.setString(3, productID);
		if (pst.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public int productQuantity(String userID, String productID) throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select quantity from cart where userID = ? and productID =?");
		pst.setString(1, userID);
		pst.setString(2, productID);
		ResultSet rs = pst.executeQuery();
		int total = 0;
		while (rs.next()) {
			total = rs.getInt("quantity");
		}
		return total;
	}
}
