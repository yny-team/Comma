package kr.or.comma.timeline.vo;

public class TimelineLikeDTO {
	
	private String timeLikeMessage;
	private int timeLikeCount;
	
	public TimelineLikeDTO(String timeLikeMessage, int timeLikeCount) {
		super();
		this.timeLikeMessage = timeLikeMessage;
		this.timeLikeCount = timeLikeCount;
	}
	
	public String getTimeLikeMessage() {
		return timeLikeMessage;
	}
	public void setTimeLikeMessage(String timeLikeMessage) {
		this.timeLikeMessage = timeLikeMessage;
	}
	public int getTimeLikeCount() {
		return timeLikeCount;
	}
	public void setTimeLikeCount(int timeLikeCount) {
		this.timeLikeCount = timeLikeCount;
	}
	@Override
	public String toString() {
		return "TimelineLikeDTO [timeLikeMessage=" + timeLikeMessage + ", timeLikeCount=" + timeLikeCount + "]";
	}
	
	
}
