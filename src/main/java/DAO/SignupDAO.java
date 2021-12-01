package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignupDAO {
	public static void signup(String id, String pw) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL, "root", "");
			Statement st = conn.createStatement();
			String sql = "INSERT INTO `account`(`username`, `password`) VALUES ('" + id + "','" + pw + "')";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
