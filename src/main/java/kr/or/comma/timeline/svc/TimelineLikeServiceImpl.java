package kr.or.comma.timeline.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.comma.timeline.dao.TimelineDAO;
import kr.or.comma.timeline.dao.TimelineLikeDAO;
import kr.or.comma.timeline.vo.TimelineLikeDTO;
import kr.or.comma.timeline.vo.TimelineLikeVO;

@Service
public class TimelineLikeServiceImpl implements TimelineLikeService {
	
	@Autowired
	private TimelineLikeDAO timelineLikeDAO;
	
	@Autowired
	private TimelineDAO timelineDAO;
	
	@Override
	public List<TimelineLikeVO> getTimelineLikeListAll() {

		return timelineLikeDAO.selectTimelineLikeListAll();
	}
	
	@Transactional
	@Override
	public int registTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO) {
		
		// TODO : timeNo에 해당하는 like_count + 1
		timelineDAO.updateTimelineLikeCountUp(timelineLikeVO.getTimeNo());
		
		return timelineLikeDAO.insertTimelineLikeBytimeNoAndUserNo(timelineLikeVO);
	}
	
	@Transactional
	@Override
	public int removeTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO) {
		
		timelineDAO.updateTimelineLikeCountDown(timelineLikeVO.getTimeNo());
		
		return timelineLikeDAO.deleteTimelineLikeBytimeNoAndUserNo(timelineLikeVO);
	}
	
	@Override
	public int getTimelineLikeCountByTimeNo(int timeNo) {
		
		return timelineLikeDAO.selectTimelineLikeCountByTimeNo(timeNo);
	}
	
	@Override
	public int getTimeLikeCountByTimeNoAndUserNo(int timeNo, int userNo) {
		
		return timelineLikeDAO.selectTimeLikeCountByTimeNoAndUserNo(timeNo, userNo);
	}
	
	@Override
	public TimelineLikeDTO getTimelineLikeMessageAndTimeLikeCount(int timeNo, int label) {
		
		String message = "좋아요";
		
		if(label == 1) {
			message = "좋아요 취소!!";
		} 
		
		return new TimelineLikeDTO(message, 
				timelineLikeDAO.selectTimelineLikeCountByTimeNo(timeNo));
	}
	
}
