package kr.or.comma.timeline.dao;

import java.util.List;

import kr.or.comma.timeline.vo.TimelineLikeVO;

public interface TimelineLikeDAO {

	public List<TimelineLikeVO> selectTimelineLikeListAll();

	public int deleteTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO);

	public int insertTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO);

	public int selectTimelineLikeCountByTimeNo(int timeNo);

	public int selectTimeLikeCountByTimeNoAndUserNo(int timeNo, int userNo);

}
