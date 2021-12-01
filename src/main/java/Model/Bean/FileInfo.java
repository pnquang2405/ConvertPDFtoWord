package Model.Bean;

public class FileInfo {
	int fileId;
	String fileName;
	boolean fileStatus;

	
	public FileInfo() {
		super();
	}
	public FileInfo(int fileId, String fileName, Boolean fileStatus) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileStatus = fileStatus;
	}
	
	public int getFileId() {
		return fileId;
	}
	
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public boolean isFileStatus() {
		return fileStatus;
	}
	
	public void setFileStatus(boolean fileStatus) {
		this.fileStatus = fileStatus;
	}
}
