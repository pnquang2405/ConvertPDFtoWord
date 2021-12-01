package Model.BO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import DAO.DownloadFileDAO;
import Model.Bean.FileInfo;

public class DownloadFileBO {
	public static FileInfo getFile (int fid) {
		return DownloadFileDAO.getFile(fid);
	}

	public static void downloadFile(int id, HttpServletResponse response) throws IOException {
		if(id!=0)
		{
			FileInfo file = DownloadFileBO.getFile(id);
			
			File folder = new File(System.getProperty("user.home") + "/" + "Words");
			if(!folder.exists())
			{
				folder.mkdir();
			}
			
			String head = folder.getAbsolutePath();
			String source = head + File.separator + file.getFileName();
			java.nio.file.Path path = Paths.get(source);
			byte[] data = Files.readAllBytes(path);
			response.setContentType("application/msword");
			response.setHeader("Content-diposition", "attachment; file-name="+file.getFileName());
			response.setContentLength(data.length);
			
			InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
			OutputStream os = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int byteRead = -1;
			while((byteRead = is.read(buffer))!=-1)
			{
				os.write(buffer, 0 , byteRead);
			}
			is.close();
			os.close();
		}
		
	}
}
