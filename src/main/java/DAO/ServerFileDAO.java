package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.FileInfo;

public class ServerFileDAO {
	public static ArrayList<FileInfo> getFileList() {
		ArrayList<FileInfo> files = new ArrayList<FileInfo>();
		try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			Statement st = conn.createStatement();	
			String sql = "Select * from fileinfo";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int fid = rs .getInt("fileId");
				String fileName = rs.getString("fileName").split("\\.")[0]+".docx";
				boolean status = rs.getBoolean("fileStatus");
				files.add(new FileInfo(fid,fileName,status));
			}
	 	}
	 	catch (Exception e){
	 		e.printStackTrace();	
	 		return null;
	 	}		
		return files;
	}
}
