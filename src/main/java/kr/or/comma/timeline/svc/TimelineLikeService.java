package kr.or.comma.timeline.svc;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineLikeDTO;
import kr.or.comma.timeline.vo.TimelineLikeVO;

public interface TimelineLikeService {
	
	public List<TimelineLikeVO> getTimelineLikeListAll();

	public int registTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO);

	public int removeTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO);

	public int getTimelineLikeCountByTimeNo(int timeNo);

	public int getTimeLikeCountByTimeNoAndUserNo(int timeNo, int userNo);

	public TimelineLikeDTO getTimelineLikeMessageAndTimeLikeCount(int timeNo, int label);
	
	
	
}
