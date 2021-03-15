package kr.or.comma.timeline.svc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.comma.timeline.dao.TimelineDAO;
import kr.or.comma.timeline.dao.TimelineFileDAO;
import kr.or.comma.timeline.vo.TimelineVO;
import kr.or.comma.timeline.vo.TimelineWithImageVO;

@Service
public class TimelineServiceImpl implements TimelineService {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineServiceImpl.class);
	
	@Autowired
	private TimelineDAO timelineDAO;
	
	@Autowired
	private TimelineFileDAO timelineFileDAO;
	
	/*
	 * 타임라인 게시물 등록
	 * @Param TimelineVO timelineVO
	 * @Return String registSuccess => success, fail
	 */
	@Transactional
	@Override
	public String registTimeline(TimelineVO timelineVO) {
		
		log.info("registTimeline : {}", timelineVO);
		
		String registSuccess = "success";
		int registSuccessCount = timelineDAO.insertTimeline(timelineVO); 
		
		if(registSuccessCount <= 0) {
			registSuccess = "fail";
			return registSuccess;
		}

		if((registSuccessCount > 0) && (timelineVO.getTimelineFileList() == null || 
				timelineVO.getTimelineFileList().size() < 0)){ // 파일 존재 X
			return registSuccess;
		} else if((registSuccessCount > 0 ) && timelineVO.getTimelineFileList() != null || 
				timelineVO.getTimelineFileList().size() > 0) { // 파일 존재 O
			timelineVO.getTimelineFileList().forEach(timelineFileList -> {
				timelineFileDAO.insertTimelineFile(timelineFileList); 
			});
		}
		 
		return registSuccess;
	}
	
	@Override
	public List<TimelineWithImageVO> getTimelineLikeTop4List() {
		
		return timelineDAO.selectTimelineLikeTop4List();
	}
	
	@Override
	public List<TimelineVO> getTimelineListAll() {
		
		return timelineDAO.selectTimelineListAll();
	}
	
	@Override
	public TimelineVO getTimelineOneByTimeNo(int timeNo) {
		
		
		
		return timelineDAO.selectTimelineOneByTimeNo(timeNo);
	}
	
	@Transactional
	@Override
	public String modifyTimeline(TimelineVO timelineVO) {
		
		log.info("modifyTimeline : {}", timelineVO);

		String modifySuccess = "success";
		
		timelineFileDAO.deleteTimelineFileAllByTimeNo(timelineVO.getTimeNo());
		
		int modifySuccessCount = timelineDAO.updateTimeline(timelineVO);
		
		if(modifySuccessCount <= 0) {
			modifySuccess = "fail";
			return modifySuccess;
		}
		
		if((modifySuccessCount > 0) && (timelineVO.getTimelineFileList() == null || 
				timelineVO.getTimelineFileList().size() < 0)){
			return modifySuccess;
		} else if((modifySuccessCount > 0 ) && timelineVO.getTimelineFileList() != null ||
				timelineVO.getTimelineFileList().size() > 0) {
			timelineVO.getTimelineFileList().forEach(timelineFileList -> {
				timelineFileList.setNo(timelineVO.getTimeNo());
				timelineFileDAO.insertReplaceTimelineFile(timelineFileList);
			});
		}
		
		return modifySuccess;
	}
	
	/*
	 * 타임라인 게시물 삭제
	 * @Param int timeNo
	 * @Return String removeSuccess => success, fail
	 */
	@Transactional
	@Override
	public String removeTimeline(int timeNo) {
		
		log.info("removeTimeline : {}", timeNo);
		String removeSuccess = "success";
		
		timelineFileDAO.deleteTimelineFileAllByTimeNo(timeNo);
		
		int removeSuccessCount = timelineDAO.deleteTimeline(timeNo);
		
		if(removeSuccessCount <= 0) {
			removeSuccess = "fail";
			return removeSuccess;
		}
		
		return removeSuccess;
	}
	
	
}
