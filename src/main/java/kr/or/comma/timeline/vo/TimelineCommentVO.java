package kr.or.comma.timeline.vo;

import java.util.Date;

public class TimelineCommentVO {
	
	private int timeCommNo; 
    private int userNo; 
    private int timeNo;
    private String timeCommContent; 
    private int timeCommLikeCount; 
    private Date timeCommCreateDt;
    private String userName;
	public int getTimeCommNo() {
		return timeCommNo;
	}
	public void setTimeCommNo(int timeCommNo) {
		this.timeCommNo = timeCommNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public String getTimeCommContent() {
		return timeCommContent;
	}
	public void setTimeCommContent(String timeCommContent) {
		this.timeCommContent = timeCommContent;
	}
	public int getTimeCommLikeCount() {
		return timeCommLikeCount;
	}
	public void setTimeCommLikeCount(int timeCommLikeCount) {
		this.timeCommLikeCount = timeCommLikeCount;
	}
	public Date getTimeCommCreateDt() {
		return timeCommCreateDt;
	}
	public void setTimeCommCreateDt(Date timeCommCreateDt) {
		this.timeCommCreateDt = timeCommCreateDt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "TimelineCommentVO [timeCommNo=" + timeCommNo + ", userNo=" + userNo + ", timeNo=" + timeNo
				+ ", timeCommContent=" + timeCommContent + ", timeCommLikeCount=" + timeCommLikeCount
				+ ", timeCommCreateDt=" + timeCommCreateDt + ", userName=" + userName + "]";
	}
}