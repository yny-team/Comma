package kr.or.comma.timeline.svc;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineVO;

public interface TimelineService {

	public String registTimeline(TimelineVO timelineVO);

	public List<TimelineVO> getTimelineListAll();

	public TimelineVO getTimelineOneByTimeNo(int timeNo);

	public String modifyTimeline(TimelineVO timelineVO);

	public String removeTimeline(int timeNo);

}
