package kr.or.comma.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.timeline.vo.TimelineVO;
import kr.or.comma.timeline.vo.TimelineWithImageVO;

@Repository
public class TimelineDAOImpl implements TimelineDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.timeline.TimelineMapper";
	
	@Override
	public List<TimelineWithImageVO> selectTimelineLikeTop4List() {
		
		return sqlSession.selectList(NAME_SPACE + ".NAME_SPACE");
	}
	
	@Override
	public int insertTimeline(TimelineVO timelineVO) {
		
		return sqlSession.insert(NAME_SPACE + ".insertTimeline", timelineVO);
	}
	
	@Override
	public List<TimelineVO> selectTimelineListAll() {
		
		return sqlSession.selectList(NAME_SPACE +  ".selectTimelineListAll");
	}
	
	@Override
	public TimelineVO selectTimelineOneByTimeNo(int timeNo) {
		
		return sqlSession.selectOne(NAME_SPACE + ".selectTimelineOneByTimeNo", timeNo);
	}
	
	@Override
	public int updateTimeline(TimelineVO timelineVO) {
		
		return sqlSession.update(NAME_SPACE + ".updateTimeline", timelineVO);
	}
	
	@Override
	public int deleteTimeline(int timeNo) {
		
		return sqlSession.delete(NAME_SPACE + ".deleteTimeline", timeNo);
	}
	
	@Override
	public void updateTimelineLikeCountUp(int timeNo) {
		
		sqlSession.update(NAME_SPACE + ".updateTimelineLikeCountUp", timeNo);
		
	}
	
	@Override
	public void updateTimelineLikeCountDown(int timeNo) {
		
		sqlSession.update(NAME_SPACE + ".updateTimelineLikeCountDown",  timeNo);
	}
	
}
