package kr.or.comma.timeline.svc;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineCommentDTO;
import kr.or.comma.timeline.vo.TimelineCommentVO;

public interface TimelineCommentService {
		
	public int registTimelineComment(TimelineCommentVO timelineCommentVO);
	
	public TimelineCommentVO getTimelineCommentOneByTimeCommNo(int timeCommNo);
	
	public int modifyTimelineComment(TimelineCommentVO timelineCommentVO);
	
	public int removeTimelineComment(int timeCommNo);
	
//	public List<TimelineCommentVO> getTimelineCommentListAll(int timeNo);
	
	public TimelineCommentDTO getTimelineCommentListAll(int timeNo);
	
}
