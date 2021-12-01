package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Bean.FileInfo;

public class DownloadFileDAO {
	public static FileInfo getFile(int fid) {
		FileInfo file = null;
		try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			Statement st = conn.createStatement();	
			String sql = "Select * from fileinfo where fileid = " + fid;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String fileName = rs.getString("fileName").split("\\.")[0]+".docx";
				boolean status = true;
				file = new FileInfo(fid,fileName,status);
			}
	 	}
	 	catch (Exception e){
	 		System.out.println("Error");	
	 		return null;
	 	}		
		return file;
	}
}
