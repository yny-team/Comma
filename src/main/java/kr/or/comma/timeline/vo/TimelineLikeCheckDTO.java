package kr.or.comma.timeline.vo;

public class TimelineLikeCheckDTO {
	
	private int timeNo;
	private boolean timeLikeDuplicateCheck;
	
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public boolean isTimeLikeDuplicateCheck() {
		return timeLikeDuplicateCheck;
	}
	public void setTimeLikeDuplicateCheck(boolean timeLikeDuplicateCheck) {
		this.timeLikeDuplicateCheck = timeLikeDuplicateCheck;
	}
	@Override
	public String toString() {
		return "TimelineLikeCheckDTO [timeNo=" + timeNo + ", timeLikeDuplicateCheck=" + timeLikeDuplicateCheck + "]";
	}
	
	
	
}
