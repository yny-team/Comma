package kr.or.comma.timeline.vo;

public class TimelineLikeCountDTO {
	
	private int timeNo;
	private int timeLikeCount;
	
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public int getTimeLikeCount() {
		return timeLikeCount;
	}
	public void setTimeLikeCount(int timeLikeCount) {
		this.timeLikeCount = timeLikeCount;
	}
	@Override
	public String toString() {
		return "TimelineLikeCountDTO [timeNo=" + timeNo + ", timeLikeCount=" + timeLikeCount + "]";
	}

}
