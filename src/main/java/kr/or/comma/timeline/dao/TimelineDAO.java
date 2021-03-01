package kr.or.comma.timeline.dao;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineVO;

public interface TimelineDAO {

	public int insertTimeline(TimelineVO timelineVO);

	public List<TimelineVO> selectTimelineListAll();

	public TimelineVO selectTimelineOneByTimeNo(int timeNo);

}
