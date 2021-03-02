package kr.or.comma.timeline.svc;

import java.util.List;

import kr.or.comma.common.vo.ImageOrFileVO;

public interface TimelineFileService {

	public List<ImageOrFileVO> getTimelineFileListAll();
	
	public List<ImageOrFileVO> getTimelineOneFileByTimeNo(int timeNo);

}
