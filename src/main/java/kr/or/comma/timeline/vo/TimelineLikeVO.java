package kr.or.comma.timeline.vo;

public class TimelineLikeVO {
	
	private int timeLikeNo;
	private int timeNo;
	private int userNo;
	
	public int getTimeLikeNo() {
		return timeLikeNo;
	}
	public void setTimeLikeNo(int timeLikeNo) {
		this.timeLikeNo = timeLikeNo;
	}
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
	
	@Override
	public String toString() {
		return "TimelineLikeVO [timeLikeNo=" + timeLikeNo + ", timeNo=" + timeNo + ", userNo=" + userNo + "]";
	}
}
