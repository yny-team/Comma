package kr.or.comma.timeline.vo;

import java.util.List;

public class TimelineCommentDTO {
	
	private int timeCommContentCount;
	private List<TimelineCommentVO> timelistCommentList;
	
	public TimelineCommentDTO(int timeCommContentCount, List<TimelineCommentVO> timelistCommentList) {
		super();
		this.timeCommContentCount = timeCommContentCount;
		this.timelistCommentList = timelistCommentList;
	}
	
	public int getTimeCommContentCount() {
		return timeCommContentCount;
	}
	public void setTimeCommContentCount(int timeCommContentCount) {
		this.timeCommContentCount = timeCommContentCount;
	}
	public List<TimelineCommentVO> getTimelistCommentList() {
		return timelistCommentList;
	}
	public void setTimelistCommentList(List<TimelineCommentVO> timelistCommentList) {
		this.timelistCommentList = timelistCommentList;
	}
	
	@Override
	public String toString() {
		return "TimelineCommentDTO [timeCommContentCount=" + timeCommContentCount + ", timelistCommentList="
				+ timelistCommentList + "]";
	}
	
	
	
}
