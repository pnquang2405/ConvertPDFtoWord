package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Bean.FileInfo;

public class ConvertFileDAO {
	public static List<FileInfo> getListConvertFile() {
		ArrayList<FileInfo> files = new ArrayList<FileInfo>();
		try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			Statement st = conn.createStatement();	
			String sql = "select * from FileInfo where filestatus = false";
			ResultSet rs = st.executeQuery(sql);	
			while (rs.next()){ 
				int fileId = rs.getInt("fileId");
				String fileName = rs.getString("fileName");
				boolean fileStatus = rs.getBoolean("fileStatus");
				files.add(new FileInfo(fileId,fileName,fileStatus));
			}
	 	}
	 	catch (Exception e){
	 		System.out.println("Error");
	 		return null;
	 	}
	 	return files;
	}
	public static void ChangStatus(int fid) {
		try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection(URL,"root","");
			Statement st = conn.createStatement();	
			String sql = "update fileinfo set filestatus = true where fileid = "+ fid;
			st.executeUpdate(sql);	
	 	}
	 	catch (Exception e){
	 		System.out.println("Error");	
	 		return;
	 	}		
	}
}
