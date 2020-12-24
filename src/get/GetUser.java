package get;

import connect.DBConnect;
import get.GetProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class GetUser {
    public ArrayList<User> getListUser() throws SQLException {
        Connection connection = DBConnect.getConnecttion();
        String sql = "SELECT * FROM user";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
           user.setUserID(rs.getInt("userID"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setEmail(rs.getString("email"));
           user.setPhone(rs.getString("phone"));
           user.setAddress(rs.getString("address"));
           user.setRole(rs.getBoolean("role"));
           list.add(user);
        }
        return list;
    }
   
    
    public boolean checkEmail(String email) throws SQLException{
    Connection connection = DBConnect.getConnecttion();
    PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
    ps.setString(1, email);
    try {
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            connection.close();
            return true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(GetUser.class.getName()).log(Level.SEVERE,null, ex);
    }
    return false;
    }
    // thêm tài khoản
    public boolean insertUser(User u) {
        Connection connection = DBConnect.getConnecttion();
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, u.getUserID());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setBoolean(7, u.getRole());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GetUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
     public User login(String username, String password) throws SQLException {
        Connection con = DBConnect.getConnecttion();
        PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
        ps.setString(1, username);
        ps.setString(2,  password);
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getBoolean("role"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     
     public User getUser(int id) throws SQLException {
     Connection con = DBConnect.getConnecttion();
     PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE userID = ?");
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     User user = new User();
     while (rs.next()) {
         
           user.setUserID(rs.getInt("userID"));
           user.setUsername(rs.getString("username"));
           user.setPassword(rs.getString("password"));
           user.setEmail(rs.getString("email"));
           user.setPhone(rs.getString("phone"));
           user.setAddress(rs.getString("address"));
           user.setRole(rs.getBoolean("role"));
     }
     return user;
}
     public boolean updateUser(User u) {
        
        Connection connection = DBConnect.getConnecttion();
        String sql = "update user SET userID=?, username=?, password=?, email=?,  phone=?,address=?, role=? WHERE userID = ?";
        
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, u.getUserID());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setBoolean(7, u.getRole());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(GetProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
