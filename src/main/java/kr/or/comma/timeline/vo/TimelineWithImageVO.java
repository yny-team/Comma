package kr.or.comma.timeline.vo;

public class TimelineWithImageVO {
	
	private int timeNo; 
	private int userNo;
	private String timeTitle;
	private String timeContent;
	private String uuid;
	private String uploadPath;
	private String fileName;
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getTimeTitle() {
		return timeTitle;
	}
	public void setTimeTitle(String timeTitle) {
		this.timeTitle = timeTitle;
	}
	public String getTimeContent() {
		return timeContent;
	}
	public void setTimeContent(String timeContent) {
		this.timeContent = timeContent;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "TimelineWithImageVO [timeNo=" + timeNo + ", userNo=" + userNo + ", timeTitle=" + timeTitle
				+ ", timeContent=" + timeContent + ", uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName="
				+ fileName + "]";
	}
	
}
