package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Brand;
import model.Category;
import model.Product;

public class CategoryDAO {

	private Connection connection = null;

	public CategoryDAO() {
		connection = DBConnect.getConnecttion();
	}
	
	private String sqlGetAll = "select * from category order by categoryName asc limit ?, ? ";
	private String sqlGetNoParams = "select * from category order by categoryName asc";
	private String sqlGet = "select * from category where categoryId = ?";
	private String sqlInsert = "insert into category values(?,?)";
	private String sqlUpdate = "update category set categoryName = ? where categoryID = ?";
	private String sqlDelete = "delete from category where categoryID = ?";

	public ArrayList<Category> getListCategory() throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sqlGetNoParams);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Category> categories = new ArrayList<>();
		Category category = null;
		while (resultSet.next()) {
			category = new Category();
			category.setCategoryID(resultSet.getString("categoryID"));
			category.setCategoryName(resultSet.getString("categoryName"));
			categories.add(category);
		}
		return categories;
	}
	
	public ArrayList<Category> getAll(int firesultSettResult, int lastResult) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
		preparedStatement.setInt(1, firesultSettResult);
		preparedStatement.setInt(2, lastResult);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Category> categories = new ArrayList<>();
		Category category = null;
		while (resultSet.next()) {
			category = new Category();
			category.setCategoryID(resultSet.getString("categoryID"));
			category.setCategoryName(resultSet.getString("categoryName"));
			categories.add(category);
		}
		return categories;
	}
	
	public Category getByID(String categoryID) throws SQLException {
		Category category = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlGet);
			preparedStatement.setString(1, categoryID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category();
				category.setCategoryID(resultSet.getString("categoryID"));
				category.setCategoryName(resultSet.getString("categoryName"));
			}
		} catch (Exception e) {
			category = null;
		}
		return category;
	}

	public boolean insert(Category c) {
		int result = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, c.getCategoryID());
			preparedStatement.setString(2, c.getCategoryName());
			result = preparedStatement.executeUpdate();
			return result == 1;
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, "Insert category: " + result, ex);
		}
		return false;
	}

	public boolean update(String categoryID, Category category) throws SQLException {
		int result = 0; 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, category.getCategoryName());
			preparedStatement.setString(2, categoryID);
			result = preparedStatement.executeUpdate();
			return result == 1;
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE,  "Update category: " + result, ex);
		}
		return false;
	}

	public boolean delete(String categoryID) {
		int result = 0; 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
			preparedStatement.setString(1, categoryID);
			result = preparedStatement.executeUpdate();
			return result == 1;
		} catch (SQLException ex) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, "Delete category: " + result, ex);
		}
		return false;
	}
}