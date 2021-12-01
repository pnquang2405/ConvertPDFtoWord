package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UploadFileDAO {
	public static void uploadFileDB(String fileName) {
		try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			PreparedStatement statement = null;
			boolean fileStatus=false;
			System.out.println("123");
			String sql = "INSERT INTO fileinfo(fileName, fileStatus)" + "VALUES (?, ?)";
			statement = conn.prepareCall(sql);
			statement.setString(1, fileName);
			statement.setBoolean(2, fileStatus);
			
			statement.execute();	
	 	}
	 	catch (Exception e){
	 		System.out.println("Error");	
	 		return;
	 	}	
		
	}
}
