package kr.or.comma.timeline.svc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.comma.common.vo.ImageOrFileVO;
import kr.or.comma.timeline.dao.TimelineDAO;
import kr.or.comma.timeline.dao.TimelineFileDAO;
import kr.or.comma.timeline.vo.TimelineVO;

@Service
public class TimelineServiceImpl implements TimelineService {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineServiceImpl.class);

	@Autowired
	private TimelineDAO timelineDAO;
	
	@Autowired
	private TimelineFileDAO timelineFileDAO;
	
	@Transactional
	@Override
	public String registTimeline(TimelineVO timelineVO) {
		
		log.info("registTimeline : {}", timelineVO);
		
		String registSuccess = "success";
		int registSuccessCount = timelineDAO.insertTimeline(timelineVO);
		
		if(registSuccessCount <= 0) {
			registSuccess = "fail";
		}

		if((registSuccessCount > 0) && (timelineVO.getTimelineFileList() == null || 
				timelineVO.getTimelineFileList().size() < 0)){
			return registSuccess;
		} else if((registSuccessCount > 0 ) && timelineVO.getTimelineFileList() != null ||
				timelineVO.getTimelineFileList().size() > 0) {
			timelineVO.getTimelineFileList().forEach(timelineFileList -> {
				timelineFileDAO.insertTimelineFile(timelineFileList);
			});
		}
		 
		
		return registSuccess;
	}
	
	@Override
	public List<TimelineVO> getTimelineListAll() {
		
		return timelineDAO.selectTimelineListAll();
	}
	
	@Override
	public TimelineVO getTimelineOneByTimeNo(int timeNo) {
		
		
		
		return timelineDAO.selectTimelineOneByTimeNo(timeNo);
	}
	
	@Override
	public List<ImageOrFileVO> getTimelineFileListAll() {
		
		return timelineFileDAO.selectTimelineFileListAll();
	}
	
	@Override
	public List<ImageOrFileVO> getTimelineOneFileByTimeNo(int timeNo) {
		
		return timelineFileDAO.selectTimelineFileOneByTimeNo(timeNo);
	}
}
