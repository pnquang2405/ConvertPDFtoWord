package Model.BO;

import Model.Bean.FileInfo;

import java.io.File;
import java.util.List;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

import DAO.ConvertFileDAO;

public class ConvertFileBO implements Runnable{

	@Override
	public void run() {
		List<FileInfo> files = ConvertFileDAO.getListConvertFile();
		for (FileInfo file : files) {
			String filename = file.getFileName().split("\\.")[0];
			try {
				Convert(filename);
				ConvertFileDAO.ChangStatus(file.getFileId());
			} catch (Exception e) {
				
			}
		}
	}
	
	private void Convert(String filename) {
		Document doc = new Document(getFolder("Uploads").getAbsolutePath() + File.separator + filename + ".pdf");

		doc.save(getFolder("Words").getAbsolutePath() + File.separator + filename + ".docx", SaveFormat.DocX);
	}

	public File getFolder(String name) {
		File folderUpload = new File(System.getProperty("user.home") + "/" + name);
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
	
}
