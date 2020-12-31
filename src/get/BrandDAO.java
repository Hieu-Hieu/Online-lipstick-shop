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
//import model.Brand;
//
//public class BrandDAO {
//
//	private Connection connection = null;
//
//	public BrandDAO() {
//		connection = DBConnect.getConnecttion();
//	}
//
//	private String sqlGetAll = "select * from brand order by brandName asc limit ?, ? ";
//	private String sqlGetNoParams = "select * from brand order by brandName asc";
//	private String sqlGet = "select * from brand where brandId = ?";
//	private String sqlInsert = "insert into brand values(?,?)";
//	private String sqlUpdate = "update brand set brandName = ? where brandID = ?";
//	private String sqlDelete = "delete from brand where brandID = ?";
//
//	public ArrayList<Brand> getListBrand() throws SQLException {
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlGetNoParams);
//		ResultSet resultSet = preparedStatement.executeQuery();
//		ArrayList<Brand> brandes = new ArrayList<>();
//		Brand brand = null;
//		while (resultSet.next()) {
//			brand = new Brand();
//			brand.setBrandID(resultSet.getInt("brandID"));
//			brand.setBrandName(resultSet.getString("brandName"));
//			brandes.add(brand);
//		}
//		return brandes;
//	}
//
//	public ArrayList<Brand> getAll(int firesultSettResult, int lastResult) throws SQLException {
//		PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
//		preparedStatement.setInt(1, firesultSettResult);
//		preparedStatement.setInt(2, lastResult);
//		ResultSet resultSet = preparedStatement.executeQuery();
//
//		ArrayList<Brand> brandes = new ArrayList<>();
//		Brand brand = null;
//		while (resultSet.next()) {
//			brand = new Brand();
//			brand.setBrandID(resultSet.getInt("brandID"));
//			brand.setBrandName(resultSet.getString("brandName"));
//			brandes.add(brand);
//		}
//		return brandes;
//	}
//
//	public Brand getByID(int brandId) throws SQLException {
//		Brand brand = null;
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlGet);
//			preparedStatement.setInt(1, brandId);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				brand = new Brand();
//				brand.setBrandID(resultSet.getInt("brandID"));
//				brand.setBrandName(resultSet.getString("brandName"));
//			}
//		} catch (Exception e) {
//			brand = null;
//		}
//		return brand;
//	}
//
//	public boolean insert(Brand c) {
//		int result = 0;
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
//			preparedStatement.setInt(1, c.getBrandID());
//			preparedStatement.setString(2, c.getBrandName());
//			result = preparedStatement.executeUpdate();
//			return result == 1;
//		} catch (SQLException ex) {
//			Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, "Insert brand: " + result, ex);
//		}
//		return false;
//	}
//
//	public boolean update(int brandID, Brand brand) throws SQLException {
//		int result = 0;
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
//			preparedStatement.setString(1, brand.getBrandName());
//			preparedStatement.setInt(2, brandID);
//			result = preparedStatement.executeUpdate();
//			return result == 1;
//		} catch (SQLException ex) {
//			Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, "Update brand: " + result, ex);
//		}
//		return false;
//	}
//
//	public boolean delete(int brandID) {
//		int result = 0;
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
//			preparedStatement.setInt(1, brandID);
//			result = preparedStatement.executeUpdate();
//			return result == 1;
//		} catch (SQLException ex) {
//			Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, "Delete brand: " + result, ex);
//		}
//		return false;
//	}
//}