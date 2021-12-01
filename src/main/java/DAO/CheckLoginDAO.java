package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Bean.Account;

public class CheckLoginDAO {
	public static Account CheckLogin(String id, String pw) {
		Account acc= new Account();
		try {
			
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			String sql = "select * from account where username =? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			ResultSet rs = ps.executeQuery();	
			if (!rs.next()){ 
				return null;
			} else {
				int accId= rs.getInt("accountId");
				String username= rs.getString("username");
				String password= rs.getString("password");
				acc = new Account(accId,username,password);
			}
	 	}
	 	catch (Exception e){
	 		System.out.println("Error");
	 		return null;
	 	}
		return acc;
	
	}
}
