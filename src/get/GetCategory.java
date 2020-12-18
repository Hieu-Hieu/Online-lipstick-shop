package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Category;

public class GetCategory {

	Connection connection = DBConnect.getConnecttion();

	public ArrayList<Category> getListCategory() throws SQLException {

		String sql = "SELECT * FROM category";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Category> list = new ArrayList<>();
		while (rs.next()) {
			Category category = new Category();
			category.setCategoryID(rs.getInt("categoryID"));
			category.setCategoryName(rs.getString("categoryName"));
			list.add(category);
		}
		return list;
	}

	public boolean insertCategory(Category c) {

		String sql = "INSERT INTO category VALUES(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			Logger.getLogger(GetCategory.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public boolean updateCateGory(Category c) throws SQLException {
		try {

			String sql = "UPDATE category SET categoryName = ? WHERE categoryID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getCategoryName());
			ps.setInt(2, c.getCategoryID());
			int temp = ps.executeUpdate();
			return temp == 1;
		} catch (SQLException ex) {
			Logger.getLogger(GetCategory.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public boolean deleteCategory(String categoryID) {

		String sql = "DELETE FROM category WHERE categoryID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, categoryID);
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			Logger.getLogger(GetCategory.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

}
