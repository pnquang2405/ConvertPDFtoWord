package Model.BO;

import java.util.ArrayList;

import DAO.ServerFileDAO;
import Model.Bean.FileInfo;

public class ServerFileBO {
	
	public static ArrayList<FileInfo> getFilelist() {
		return ServerFileDAO.getFileList();
	}
}
