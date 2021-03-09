package kr.or.comma.timeline.dao;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineVO;

public interface TimelineDAO {

	public int insertTimeline(TimelineVO timelineVO);

	public List<TimelineVO> selectTimelineListAll();

	public TimelineVO selectTimelineOneByTimeNo(int timeNo);

	public int updateTimeline(TimelineVO timelineVO);

	public int deleteTimeline(int timeNo);

	public void updateTimelineLikeCountUp(int timeNo);

	public void updateTimelineLikeCountDown(int timeNo);

}
