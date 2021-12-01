package Model.BO;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import DAO.UploadFileDAO;


public class UploadFileBO implements Runnable{
	HttpServletRequest request;
	
	public UploadFileBO(HttpServletRequest request) {
		this.request = request;
	}
	public static void uploadFileDB(String fileName) {
		UploadFileDAO.uploadFileDB(fileName);
	}
	
	@Override
	public void run() {
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				part.write(getFolderUpload().getAbsolutePath() + File.separator + fileName);
				UploadFileBO.uploadFileDB(fileName);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			
		}
		new ConvertFileBO().run();
	}
	
	private static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	
	public static File getFolderUpload() {
		File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
	
}
