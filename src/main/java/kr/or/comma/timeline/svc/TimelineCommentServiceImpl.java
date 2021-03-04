package kr.or.comma.timeline.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.comma.timeline.dao.TimelineCommentDAO;
import kr.or.comma.timeline.vo.TimelineCommentVO;

@Service
public class TimelineCommentServiceImpl implements TimelineCommentService {
	
	@Autowired
	private TimelineCommentDAO timelineCommentDAO;
	
	@Override
	public int registTimelineComment(TimelineCommentVO timelineCommentVO) {

		return timelineCommentDAO.insertTimelineComment(timelineCommentVO);
	}
	
	@Override
	public TimelineCommentVO getTimelineCommentOneByTimeCommNo(int timeCommNo) {

		return timelineCommentDAO.selectTimelineCommentOneByTimeCommNo(timeCommNo);
	}
	
	@Override
	public int modifyTimelineComment(TimelineCommentVO timelineCommentVO) {

		return timelineCommentDAO.updateTimelineComment(timelineCommentVO);
	}
	
	@Override
	public int removeTimelineComment(int timeCommNo) {

		return timelineCommentDAO.deleteTimelineComment(timeCommNo);
	}
	
	@Override
	public List<TimelineCommentVO> getTimelineCommentListAll(int timeNo) {

		return timelineCommentDAO.selectTimelineCommentListAll(timeNo);
	}
	
	
}
