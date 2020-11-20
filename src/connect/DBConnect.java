package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnecttion() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/lipstickshop", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cons;
	}
}
