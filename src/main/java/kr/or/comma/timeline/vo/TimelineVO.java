package kr.or.comma.timeline.vo;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kr.or.comma.common.vo.ImageOrFileVO;

public class TimelineVO {
	
   private int timeNo; 
   private int userNo;
   private String userName;
   
   @NotBlank
   @Size(min = 1, max=255)
   private String timeTitle;
   
   @NotBlank
   @Size(min = 1, max=4000)
   private String timeContent;
   private int timeViewCount;
   private int timeLikeCount;
   private int timeCommCount;
   private Date timeCreateDt;
   private String timeOpenScope;
   private List<ImageOrFileVO> timelineFileList;
   
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
   public String getUserName() {
	   return userName;
   }
   public void setUserName(String userName) {
		this.userName = userName;
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
   public int getTimeViewCount() {
      return timeViewCount;
   }
   public void setTimeViewCount(int timeViewCount) {
      this.timeViewCount = timeViewCount;
   }
   public int getTimeLikeCount() {
      return timeLikeCount;
   }
   public void setTimeLikeCount(int timeLikeCount) {
      this.timeLikeCount = timeLikeCount;
   }
   
   public int getTimeCommCount() {
	return timeCommCount;
   }
   public void setTimeCommCount(int timeCommCount) {
		this.timeCommCount = timeCommCount;
	}
	public Date getTimeCreateDt() {
	      return timeCreateDt;
	   }
   public void setTimeCreateDt(Date timeCreateDt) {
      this.timeCreateDt = timeCreateDt;
   }
   public String getTimeOpenScope() {
      return timeOpenScope;
   }
   public void setTimeOpenScope(String timeOpenScope) {
      this.timeOpenScope = timeOpenScope;
   }
   
   public List<ImageOrFileVO> getTimelineFileList() {
	return timelineFileList;
   }
	public void setTimelineFileList(List<ImageOrFileVO> timelineFileList) {
		this.timelineFileList = timelineFileList;
	}
	@Override
	public String toString() {
		return "TimelineVO [timeNo=" + timeNo + ", userNo=" + userNo + ", userName=" + userName + ", timeTitle="
				+ timeTitle + ", timeContent=" + timeContent + ", timeViewCount=" + timeViewCount + ", timeLikeCount="
				+ timeLikeCount + ", timeCommCount=" + timeCommCount + ", timeCreateDt=" + timeCreateDt
				+ ", timeOpenScope=" + timeOpenScope + ", timelineFileList=" + timelineFileList + "]";
	}

	
	
}