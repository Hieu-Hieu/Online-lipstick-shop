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
        String sql = "SELECT * FROM users";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
           user.setid(rs.getString("user_id"));
           user.setusername(rs.getString("user_name"));
           user.setpassword(rs.getString("user_pass"));
           user.setemail(rs.getString("user_email"));
           user.setphone(rs.getString("user_phone"));
           user.setaddress(rs.getString("user_address"));
           user.setrole(rs.getBoolean("user_role"));
           list.add(user);
        }
        return list;
    }
   
    
    public boolean checkEmail(String name) throws SQLException{
    Connection connection = DBConnect.getConnecttion();
    String sql = "SELECT * FROM users WHERE user_name = '" + name + "'";
    PreparedStatement ps;
    try {
        ps = connection.prepareCall(sql);
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
            ps.setString(1, u.getid());
            ps.setString(2, u.getusername());
            ps.setString(3, u.getpassword());
            ps.setString(4, u.getemail());
            ps.setString(5, u.getphone());
            ps.setString(5, u.getaddress());
            ps.setBoolean(7, u.isrole());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GetUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
     public User login(String name, String password) {
        Connection con = DBConnect.getConnecttion();
        String sql = "select * from users where user_name='" + name + "' and user_pass='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setid(rs.getString("user_id"));
                u.setusername(rs.getString("user_name"));
                u.setpassword(rs.getString("user_pass"));
                u.setrole(rs.getBoolean("user_role"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     
     public User getUser(long id) throws SQLException {
     Connection connection = DBConnect.getConnecttion();
     String sql = "SELECT * FROM users WHERE user_id = '" + id + "'";
     PreparedStatement ps = connection.prepareCall(sql);
     ResultSet rs = ps.executeQuery();
     User user = new User();
     while (rs.next()) {
         
           user.setid(rs.getString("user_id"));
           user.setusername(rs.getString("user_name"));
           user.setpassword(rs.getString("user_pass"));
           user.setemail(rs.getString("user_email"));
           user.setphone(rs.getString("user_phone"));
           user.setaddress(rs.getString("user_address"));
           user.setrole(rs.getBoolean("user_role"));
     }
     return user;
}
     public boolean updateUser(User u) {
        
        Connection connection = DBConnect.getConnecttion();
       // String sql = "UPDATE product SET product_id = ?, category_id = ?, product_name = ?, product_image = ?, product_image_forward = ?, product_image_back = ?, product_price = ?, product_description = ? WHERE product_id = ?";
        String sql = "UPDATE users SET user_id=?, user_name=?, user_pass=?, user_email=?,  user_phone=?, user_address?, user_role=? WHERE user_id = ?";
        
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, u.getid());
            ps.setString(2, u.getusername());
            ps.setString(3, u.getpassword());
            ps.setString(4, u.getemail());
            ps.setString(5, u.getphone());
            ps.setString(5, u.getaddress());
            ps.setBoolean(7, u.isrole());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(GetProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
