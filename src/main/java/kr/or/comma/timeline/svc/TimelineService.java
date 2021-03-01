package kr.or.comma.timeline.svc;

import java.util.List;

import kr.or.comma.common.vo.ImageOrFileVO;
import kr.or.comma.timeline.vo.TimelineVO;

public interface TimelineService {

	public String registTimeline(TimelineVO timelineVO);

	public List<TimelineVO> getTimelineListAll();

	public TimelineVO getTimelineOneByTimeNo(int timeNo);

	public List<ImageOrFileVO> getTimelineFileListAll();

	public List<ImageOrFileVO> getTimelineOneFileByTimeNo(int timeNo);

}
