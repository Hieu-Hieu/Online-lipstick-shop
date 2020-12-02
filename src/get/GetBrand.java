package get;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.Brand;
import model.Product;

public class GetBrand {
	
	DBConnect mydb = new DBConnect();
	Connection conn = mydb.getConnecttion();
	
	public boolean addBrand(Brand brand) throws SQLException {

		PreparedStatement st = conn.prepareStatement("insert into brand values(?, ?)");
		st.setString(1, brand.getBrandID());
		st.setString(2, brand.getBrandName());
		
		if (st.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateBrand(Brand c) throws SQLException {
	    try {
	         String sql = "UPDATE brand SET brandName = ? WHERE brandID = ?";
	         PreparedStatement ps = conn.prepareCall(sql);
	         ps.setString(1, c.getBrandName());
	         ps.setString(2, c.getBrandID());
	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	         return false;
	    }
	}
	
	public boolean deleteBrand(String brandID) throws SQLException {
	    try {
	        String sql = "DELETE FROM brand WHERE brandID = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, brandID);
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	 public ArrayList<Brand> getListBrand() throws SQLException {
	       
	        String sql = "SELECT * FROM brand";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        ArrayList<Brand> list = new ArrayList<>();
	        while (rs.next()) {
	            Brand brand = new Brand();
	            brand.setBrandID(rs.getString("brandID"));
	            brand.setBrandName(rs.getString("brandName"));
	            list.add(brand);
	        }
	        return list;
	    }
	 
	 public Brand getBrandByID(String brandID) throws SQLException {
	        Connection connection = DBConnect.getConnecttion();
	        String sql =  "SELECT * FROM brand WHERE brandID = ?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, brandID);
	        ResultSet rs = ps.executeQuery();
	        Brand brand = new Brand();
	        while (rs.next()) {
	            
	            brand.setBrandID(rs.getString("brandID"));
	            brand.setBrandName(rs.getString("brandName"));
	           
	        }
	        return brand;
	    }
}
