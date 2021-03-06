package kr.or.comma.timeline.dao;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineCommentVO;

public interface TimelineCommentDAO {
	
	public int insertTimelineComment(TimelineCommentVO timelineCommentVO);
	
	public TimelineCommentVO selectTimelineCommentOneByTimeCommNo(int timeCommNo);
	
	public int updateTimelineComment(TimelineCommentVO timelineCommentVO);
	
	public int deleteTimelineComment(int timeCommNo);
	
	public List<TimelineCommentVO> selectTimelineCommentListAll(int timeNo);

	public int selectTimelineCommentCountByTimeNo(int timeNo);

}
