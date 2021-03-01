package kr.or.comma.common.vo;

public class ImageOrFileVO {
	
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private int no;
	
	public String getUuid() {
		return uuid;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public boolean isFileType() {
		return fileType;
	}
	public int getNo() {
		return no;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileType(boolean fileType) {
		this.fileType = fileType;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "ImageOrFileVO [uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", fileType="
				+ fileType + ", no=" + no + "]";
	}
}
