package kr.or.comma.timeline.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.comma.common.vo.ImageOrFileVO;
import kr.or.comma.timeline.dao.TimelineFileDAO;

@Service
public class TimelineFileServiceImpl implements TimelineFileService {

	@Autowired
	private TimelineFileDAO timelineFileDAO;
	
	@Override
	public List<ImageOrFileVO> getTimelineFileListAll() {
		
		return timelineFileDAO.selectTimelineFileListAll();
	}
	
	@Override
	public List<ImageOrFileVO> getTimelineOneFileByTimeNo(int timeNo) {
		
		return timelineFileDAO.selectTimelineFileOneByTimeNo(timeNo);
	}

}
